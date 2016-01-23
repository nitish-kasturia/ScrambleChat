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
public class FourthFragment extends Fragment {


    public FourthFragment() {
        // Required empty public constructor
    }

    public static FourthFragment newInstance() {
        return new FourthFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

}
