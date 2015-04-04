
package com.linaresdigital.android.androidcameraserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.preference.PreferenceManager;
import android.util.Log;

import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.Toast;

import android.content.Context;
import android.content.SharedPreferences;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.AutoFocusCallback;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder mHolder;
    private Camera mCamera;
    private Camera.Parameters mParameters;
    private PreviewCallback previewCallback;
    private AutoFocusCallback autoFocusCallback;
    private float bytesperPixel = 0;
    private float totalBytes = 0;
    private static List<List<Integer>> reslist = new ArrayList<List<Integer>>();
    

    public CameraPreview(Context context, Camera camera,
                         PreviewCallback previewCb,
                         AutoFocusCallback autoFocusCb) {
        super(context);
        mCamera = camera;
        previewCallback = previewCb;
        autoFocusCallback = autoFocusCb;
        mParameters = camera.getParameters();
        List<Camera.Size> sizes = mParameters.getSupportedPreviewSizes();
        bytesperPixel = ((float)ImageFormat.getBitsPerPixel(mParameters.getPreviewFormat()))/8;
        
        Camera.Size result;
        for (int i=0;i<sizes.size();i++){
            result = (Camera.Size) sizes.get(i);
            totalBytes = result.width*result.height*bytesperPixel;
            if(totalBytes < 1048576){
            	reslist.add(Arrays.asList(result.width, result.height));
            }
            Log.i("Resolution", "Width: " + result.width + " x Height: " + result.height); 
            Log.i("Bytes", bytesperPixel + " " + totalBytes ); 
        }
        //SharedPreferences settings = getSharedPreferences("");
        //mParameters.setPreviewSize(320, 240);
        mParameters.setPreviewSize(1280, 720);
        /*mParameters.setPreviewFormat(ImageFormat.YUY2);*/

        /* 
         * Set camera to continuous focus if supported, otherwise use
         * software auto-focus. Only works for API level >=9.
         */
        for (String f : mParameters.getSupportedFocusModes()) {
            if (f == Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO) {
            	mParameters.setFocusMode(f);
                autoFocusCallback = null;
                break;
            }
        }

        mCamera.setParameters(mParameters);
        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);

        // deprecated setting, but required on Android versions prior to 3.0
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
            
        } catch (IOException e) {
            Log.d("DBG", "Error setting camera preview: " + e.getMessage());
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // Camera preview released in activity
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        /*
         * If your preview can change or rotate, take care of those events here.
         * Make sure to stop the preview before resizing or reformatting it.
         */
        if (mHolder.getSurface() == null){
          // preview surface does not exist
          return;
        }

        // stop preview before making changes
        try {
            mCamera.stopPreview();
        } catch (Exception e){
          // ignore: tried to stop a non-existent preview
        }

        try {
            // Hard code camera surface rotation 90 degrees to match Activity view in portrait
            mCamera.setDisplayOrientation(0);

            mCamera.setPreviewDisplay(mHolder);
            mCamera.setPreviewCallback(previewCallback);
            mCamera.startPreview();
            mCamera.autoFocus(autoFocusCallback);
        } catch (Exception e){
            Log.d("DBG", "Error starting camera preview: " + e.getMessage());
        }
    }

    public void setFlashMode(String value){
        if(mCamera != null){
        	mCamera.cancelAutoFocus();
        	mParameters = mCamera.getParameters();
        	mParameters.setFlashMode(value);
            mCamera.setParameters(mParameters);
            mCamera.autoFocus(autoFocusCallback);
        }
    }
    
    public List<List<Integer>> getResList (){
    	return reslist;
    }
}
