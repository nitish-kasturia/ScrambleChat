package com.nitishkasturia.scramblechat.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitishkasturia.scramblechat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment {


    public ShareFragment() {
        // Required empty public constructor
    }

    public static ShareFragment newInstance() {
        return new ShareFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false);
    }

}
