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
public class ScrambleFragment extends Fragment {


    public ScrambleFragment() {
        // Required empty public constructor
    }

    public static ScrambleFragment newInstance() {
        return new ScrambleFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scramble, container, false);
    }

}
