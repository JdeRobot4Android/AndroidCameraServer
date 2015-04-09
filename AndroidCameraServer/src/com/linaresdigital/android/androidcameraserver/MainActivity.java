/**
 * Actividad de prueba que enmarca y controla tanto la vista preliminar de la cámara como la
 * interfaz ICE publicada.
 * 
 * @author Óscar Javier García Baudet
 * @version 1.0, 2013-01-08
 */

package com.linaresdigital.android.androidcameraserver;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnLayoutChangeListener {

  private static final String TAG = MainActivity.class.getClass().getName();
  /** Instance of ImageProvider implementation to be published */
  private CameraI cameraA;
  /** Instance of camera to be used in activity */
  static private Camera mCamera;
  /** Instance of implementation of the camera preview that we'll use */
  private CameraPreview mPreview;
  /** Handler for autofocus when camera doesn't support it */
  private Handler autoFocusHandler;
  /** Previewing state */
  private boolean previewing = false;
  /** Frame layout what contents surface preview */
  private FrameLayout preview;
  private SharedPreferences prefs;

  private String adapterendpoints = " -h 0.0.0.0 -p ";
  private String port = "9999";
  private String protocol = "default";
  private int width;
  private int height;
  private String dimensions;
  PowerManager.WakeLock wl;

  /**
   * Prepare and configure activity
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
    wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /* We require landscape orientation */
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    /* Provide continuous autofocus if camera does not support it */
    autoFocusHandler = new Handler();
    prefs = PreferenceManager.getDefaultSharedPreferences(this);
    // Get the value for port and protocol
    port = prefs.getString("Port Number", "9999");
    protocol = prefs.getString("protocol", "default");

    // SSL initialization can take some time. To avoid blocking the
    // calling thread, we perform the initialization in a separate thread.
    new Thread(new Runnable() {
      public void run() {
        initializeCommunicator();
      }
    }).start();
  }

  /**
   * Safe way to get the instance of camera
   */
  public static Camera getCameraInstance() {
    Camera camara = null;
    try {
      /* Open the camera */
      camara = Camera.open();
    } catch (Exception e) {
      Log.e(TAG, "No se pudo inicializar la cámara");
    }
    return camara;
  }

  /**
   * Release all camera resources
   */
  private void releaseCamera() {
    if (mCamera != null) {
      /* Disable callbacks */
      mCamera.setPreviewCallback(null);
      mCamera.stopPreview();
      mCamera.lock();
      mCamera.release();
      mCamera = null;
      /* Save the state */
      previewing = false;
    }
  }

  private Runnable doAutoFocus = new Runnable() {

    public void run() {
      if (previewing)
        mCamera.autoFocus(autoFocusCB);
    }
  };

  PreviewCallback previewCb = new PreviewCallback() {
    public void onPreviewFrame(byte[] data, Camera camera) {
      previewing = true;
      try {
        if (CameraI.idDatos == null)
          return;
        Camera.Parameters parameters = camera.getParameters();
        Size size = parameters.getPreviewSize();
        switch (parameters.getPreviewFormat()) {
          case ImageFormat.NV21:
            CameraI.idDatos.format = "NV21";
            break;
          case ImageFormat.YUY2:
            CameraI.idDatos.format = "YUY2";
          default:
            CameraI.idDatos.format = "YCRCB";
        }
        CameraI.idDatos.width = size.width;
        CameraI.idDatos.height = size.height;
        CameraI.idImagen.pixelData = data.clone();
        long milisegundos = System.currentTimeMillis();
        CameraI.idImagen.timeStamp.seconds = (long) (milisegundos / 1000);
        CameraI.idImagen.timeStamp.useconds = (milisegundos % 1000) * 1000;
        new Thread(new Runnable() {
          public void run() {
            CameraI.Job actual;
            while ((actual = CameraI._jobs.poll()) != null) {
              actual.execute();
            }
          }
        }).start();
        /*
         * CameraI.Job actual; while ((actual = CameraI._jobs.poll()) != null) { actual.execute(); }
         */
      } catch (Exception ex) {
        Log.e(TAG, "Prueba");
      }
    }
  };

  AutoFocusCallback autoFocusCB = new AutoFocusCallback() {
    public void onAutoFocus(boolean success, Camera camera) {
      autoFocusHandler.postDelayed(doAutoFocus, 3500);
    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_settings:
        Intent i = new Intent(this, Preferences.class);
        startActivity(i);
        break;
    }
    return true;
  }

  /**
   * When the layout is about to change (size is calculated previously) use the size of parent frame
   * to calculate own size to keep preview surface's aspect ratio
   */
  @Override
  public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft,
      int oldTop, int oldRight, int oldBottom) {
    /* Get parent layout (relative frame) to know total application size */
    RelativeLayout rootLayout = (RelativeLayout) v.getParent();
    /* Avoid calling this event listener again */
    v.removeOnLayoutChangeListener(this);
    /* Get preview frame parameters to change it to keep aspect ratio */
    RelativeLayout.LayoutParams layoutPreviewParams =
        (RelativeLayout.LayoutParams) preview.getLayoutParams();
    /* Calculations needed to keep camera preview aspect ratio */
    double rootAspectRatio = (double) rootLayout.getWidth() / (double) rootLayout.getHeight();
    double previewAspectRatio = (double) width / (double) height;
    if (rootAspectRatio > previewAspectRatio) {
      /* The height will be the same as parent */
      layoutPreviewParams.height = rootLayout.getHeight();
      /* We need to calculate width to keep aspect ratio */
      layoutPreviewParams.width = (int) ((double) rootLayout.getHeight() * previewAspectRatio);
    } else {
      /* The width will be the same as parent */
      layoutPreviewParams.width = rootLayout.getWidth();
      /* We need to calculate height to keep aspect ratio */
      layoutPreviewParams.height = (int) ((double) rootLayout.getWidth() * previewAspectRatio);
    }
    /* Tell frame to center in parent relative frame */
    layoutPreviewParams.addRule(RelativeLayout.CENTER_IN_PARENT);
    preview.setLayoutParams(layoutPreviewParams);
  }

  public void onStop() {
    super.onStop();
  }

  public void onPause() {
    releaseCamera();
    preview.removeAllViews();
    mPreview = null;
    Log.e(TAG, wl.isHeld() + "");
    if (wl.isHeld() == true) {
      wl.release();

    }
    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    super.onPause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    /* Test if preferences was modified */
    if (Preferences.modified) {
      /* Clear modified flag */
      Preferences.modified = false;
      /* Finish this Activity and reload it again */
      Toast.makeText(getApplicationContext(), R.string.application_reload, Toast.LENGTH_LONG).show();
      this.finish();
      Intent i = new Intent(this, MainActivity.class);
      startActivity(i);
    }
    /* Get an instance of the default camera */
    mCamera = getCameraInstance();
    if (mCamera == null) {
      Toast.makeText(getApplicationContext(), R.string.error_camera, Toast.LENGTH_LONG).show();
      this.finish();
    }

    dimensions = prefs.getString("listpref", "320 240");
    width = Integer.parseInt(dimensions.substring(0, dimensions.indexOf(" ")));
    height =
        Integer.parseInt(dimensions.substring(dimensions.indexOf(" ") + 1, dimensions.length()));

    /* We create an instance of CameraPreview to manage the camera */
    mPreview = new CameraPreview(this, mCamera, previewCb, autoFocusCB, width, height);

    /* Find the frame that will contain the camera preview */
    preview = (FrameLayout) findViewById(R.id.frameLayout);

    /* Change preview size when it have been displayed */
    preview.addOnLayoutChangeListener(this);

    /* Add view to frame */
    preview.addView(mPreview);

    // Get the port and protocol
    port = prefs.getString("Port Number", "9999");
    protocol = prefs.getString("protocol", "default");

    // Check wakelock and lockscreen
    if (prefs.getBoolean("lockscreen", false) == true) {
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    } else {
      getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    if (prefs.getBoolean("wakelock", false) == true) {
      wl.acquire();
    }

    // Initialize the Communicator again as ports and protocol have been
    // changed
    new Thread(new Runnable() {
      public void run() {
        initializeCommunicator();
      }
    }).start();
  }

  /* Implementation of ICE */
  interface CommunicatorCallback {
    void onWait();

    void onCreate(Ice.Communicator communicator);

    void onError(Ice.LocalException ex);
  }

  private Ice.Communicator _communicator;
  private CommunicatorCallback _cb;

  private void initializeCommunicator() {
    try {
      Ice.Communicator communicator;
      Ice.InitializationData initData = new Ice.InitializationData();
      initData.properties = Ice.Util.createProperties();
      initData.properties.setProperty("Ice.Trace.Network", "3");

      communicator = Ice.Util.initialize(initData);
      Ice.ObjectAdapter adapter =
          communicator.createObjectAdapterWithEndpoints("CameraAdapter", protocol
              + adapterendpoints + port);
      cameraA = new CameraI();
      adapter.add((Ice.Object) cameraA, Ice.Util.stringToIdentity("cameraA"));
      adapter.activate();

      synchronized (this) {
        _communicator = communicator;
        if (_cb != null) {
          _cb.onCreate(_communicator);
        }
      }
    } catch (Ice.LocalException ex) {
      synchronized (this) {
        if (_cb != null) {
          _cb.onError(ex);
        }
      }
    }
  }
}
