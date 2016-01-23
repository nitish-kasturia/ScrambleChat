package com.nitishkasturia.scramblechat.ui;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.nitishkasturia.scramblechat.R;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */


public class SelfieFragment extends Fragment {

    public SelfieFragment() {
        // Required empty public constructor
    }

    public static SelfieFragment newInstance() {
        return new SelfieFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment.

        View view = inflater.inflate(R.layout.fragment_selfie, container, false);
        SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.surfaceView);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();

        surfaceHolder.addCallback(new SurfaceHolder.Callback(){
            private Camera mCamera;
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mCamera = android.hardware.Camera.open();

                try {
                    mCamera.setPreviewDisplay(holder);
                }catch(IOException exception) {
                    mCamera.release();
                    mCamera = null;
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                mCamera.startPreview();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }
        });


//        mCameraButton = (Button) view.findViewById(R.id.cameraButton);
//
//        mCameraButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent cameraOpen = new Intent("android.media.action.IMAGE_CAPTURE");
//                startActivity(cameraOpen);
//            }
//        });
//
        return view;
    }
}
