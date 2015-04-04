/**
 * Actividad de prueba que enmarca y controla tanto la vista preliminar de la
 * cámara como la interfaz ICE publicada.
 * 
 * @author Óscar Javier García Baudet
 * @version 1.0, 2013-01-08
 */

package com.linaresdigital.android.androidcameraserver;

import java.util.ArrayList;
import java.util.List;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
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
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getClass().getName();
	/**
	 * Instance of ImageProvider implementation to be published
	 */
	private CameraI cameraA;
	/**
	 * Instance of camera to be used in activity
	 */
	static private Camera mCamera;
	/**
	 * Instance of implementation of the camera preview that we'll use
	 */
	private CameraPreview mPreview;
	private Handler autoFocusHandler;
	private boolean previsualizando = false;
	private FrameLayout preview;
	private static List<List<Integer>> reslist = new ArrayList<List<Integer>>();
	
	private String adapterendpoints = " -h 0.0.0.0 -p ";
	private String port = "9999";
	private String protocol = "default";
	private int width;
	private int height;
	private String dimensions;
	PowerManager.WakeLock wl;
	

	/**
	 * 
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
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(this);
		dimensions = prefs.getString("listpref", "320 240");	
		width = Integer.parseInt(dimensions.substring(0, dimensions.indexOf(" ")));
		height = Integer.parseInt(dimensions.substring(dimensions.indexOf(" ")+1, dimensions.length()));
		
		//Toast.makeText(getApplicationContext(), dimensions.substring(0, dimensions.indexOf(" ")), Toast.LENGTH_LONG).show();
		//Toast.makeText(getApplicationContext(), dimensions.substring(dimensions.indexOf(" ")+1, dimensions.length()), Toast.LENGTH_LONG).show();
		
		//Get the value for port and protocol
		port = prefs.getString("Port Number", "9999");
		protocol = prefs.getString("protocol", "default");
		
		//Check wakelock and lockscreen
		if(prefs.getBoolean("lockscreen", false) == true){
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
		if(prefs.getBoolean("wakelock", false)== true){
			wl.acquire();
		}
		
		/* Initialize ICE, copied from an example */
		/**************************************************************************/
		if (VERSION.SDK_INT == 8) // android.os.Build.VERSION_CODES.FROYO (8)
		{
			//
			// Workaround for a bug in Android 2.2 (Froyo).
			//
			// See http://code.google.com/p/android/issues/detail?id=9431
			//
			java.lang.System.setProperty("java.net.preferIPv4Stack", "true");
			java.lang.System.setProperty("java.net.preferIPv6Addresses",
					"false");
		}

		/* Continuing the example copied */
		// SSL initialization can take some time. To avoid blocking the
		// calling thread, we perform the initialization in a separate thread.
		new Thread(new Runnable() {
			public void run() {
				initializeCommunicator();
			}
		}).start();
		/**************************************************************************/
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

	private void releaseCamera() {
		if (mCamera != null) {
			/* Disable callbacks */
			mCamera.setPreviewCallback(null);
			mCamera.stopPreview();
			mCamera.lock();
			mCamera.release();
			mCamera = null;
			/* Save the state */
			previsualizando = false;
		}
	}

	private Runnable doAutoFocus = new Runnable() {

		public void run() {
			if (previsualizando)
				mCamera.autoFocus(autoFocusCB);
		}
	};

	PreviewCallback previewCb = new PreviewCallback() {
		public void onPreviewFrame(byte[] data, Camera camera) {
			previsualizando = true;
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
				 * CameraI.Job actual; while ((actual = CameraI._jobs.poll()) !=
				 * null) { actual.execute(); }
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
            int[][] resolution = new int[reslist.size()][2];
            for(int a = 0; a < reslist.size(); a++){
            	resolution[a][0] = reslist.get(a).get(0);
            	resolution[a][1] = reslist.get(a).get(1); 	
            }
            Bundle b=new Bundle();
            b.putSerializable("Array", resolution);
            i.putExtras(b);
            startActivity(i);
            break;
 
        }
 
        return true;
    }
	
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//	    if (requestCode == 1) {
//	        if(resultCode == RESULT_OK){
//	            String result=data.getStringExtra("result");
//	            adapterendpoints = "default -h 0.0.0.0 -p "+ result;
//	            new Thread(new Runnable() {
//	    			public void run() {
//	    				initializeCommunicator();
//	    			}
//	    		}).start();
//	        }
//	        if (resultCode == RESULT_CANCELED) {
//	            //Code if there's no result
//	        }
//	    }
//	}//onActivityResult
	
	public void onStop() {
		super.onStop();
	}

	public void onPause() {
		releaseCamera();
		preview.removeAllViews();
		mPreview = null;
		Log.e(TAG, wl.isHeld() + "" );
		if(wl.isHeld()==true){
			 wl.release();
			
		}
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		/* Get an instance of the default camera */
		mCamera = getCameraInstance();
		if (mCamera == null) {
			Toast.makeText(getApplicationContext(), R.string.error_camera, Toast.LENGTH_LONG).show();
			this.finish();
		}
		
		/* We call the Preferences and get the selected values*/
		SharedPreferences prefs = PreferenceManager
			    .getDefaultSharedPreferences(this);
		dimensions = prefs.getString("listpref", "320 240");
		width = Integer.parseInt(dimensions.substring(0, dimensions.indexOf(" ")));
		height = Integer.parseInt(dimensions.substring(dimensions.indexOf(" ")+1, dimensions.length()));
		
		/* We create an instance of CameraPreview to manage the camera */
		mPreview = new CameraPreview(this, mCamera, previewCb, autoFocusCB, width, height);
		reslist = mPreview.getResList();
		/* Find the frame that will contain the camera preview */
		preview = (FrameLayout) findViewById(R.id.frameLayout);
		/* Add view to frame */
		preview.addView(mPreview);
		
		//Get the port and protocol
		port = prefs.getString("Port Number", "9999");
		protocol = prefs.getString("protocol", "default");
		
		//Check wakelock and lockscreen
		if(prefs.getBoolean("lockscreen", false) == true){
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}else{
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
		if(prefs.getBoolean("wakelock", false)== true){
			wl.acquire();
		}
//		Toast.makeText(getApplicationContext(), prefs.getBoolean("lockscreen", false) + "lockscreen", Toast.LENGTH_LONG).show();
//		Toast.makeText(getApplicationContext(), prefs.getBoolean("wakelock", false) + "wakelock", Toast.LENGTH_LONG).show();
		//Initialize the Communicator again as ports and protocol have been changed
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
			
			//
			// Only configure IceSSL if we are using Froyo or later.
			//
			/*
			 * if(VERSION.SDK_INT >= 8) // android.os.Build.VERSION_CODES.FROYO
			 * (8) { initData.properties.setProperty("IceSSL.Trace.Security",
			 * "3"); initData.properties.setProperty("IceSSL.KeystoreType",
			 * "BKS"); initData.properties.setProperty("IceSSL.TruststoreType",
			 * "BKS"); initData.properties.setProperty("IceSSL.Password",
			 * "password"); initData.properties.setProperty("Ice.InitPlugins",
			 * "0"); initData.properties.setProperty("Ice.Plugin.IceSSL",
			 * "IceSSL.PluginFactory"); }
			 */

			communicator = Ice.Util.initialize(initData);
			Ice.ObjectAdapter adapter = communicator
					.createObjectAdapterWithEndpoints("CameraAdapter",
							protocol +adapterendpoints + port);
			cameraA = new CameraI();
			adapter.add((Ice.Object) cameraA,
					Ice.Util.stringToIdentity("cameraA"));
			adapter.activate();
			
			
			Log.e(TAG, cameraA.ice_id());

			/*
			 * if(VERSION.SDK_INT >= 8) // android.os.Build.VERSION_CODES.FROYO
			 * (8) { IceSSL.Plugin plugin =
			 * (IceSSL.Plugin)communicator.getPluginManager
			 * ().getPlugin("IceSSL"); // // Be sure to pass the same input
			 * stream to the SSL plug-in for // both the keystore and the
			 * truststore. This makes startup a // little faster since the
			 * plugin will not initialize // two keystores. //
			 * java.io.InputStream certs =
			 * getResources().openRawResource(R.raw.certs);
			 * plugin.setKeystoreStream(certs);
			 * plugin.setTruststoreStream(certs);
			 * communicator.getPluginManager().initializePlugins(); }
			 */

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
