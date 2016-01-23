package com.nitishkasturia.scramblechat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nitishkasturia.scramblechat.R;

/**
 * A simple {@link Fragment} subclass.
 */


public class SelfieFragment extends Fragment {

    Button mCameraButton;

    public SelfieFragment() {
        // Required empty public constructor
    }

    public static SelfieFragment newInstance() {
        return new SelfieFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selfie, container, false);

        mCameraButton = (Button) view.findViewById(R.id.cameraButton);

        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraOpen = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(cameraOpen);
            }
        });

        return view;
    }
}
