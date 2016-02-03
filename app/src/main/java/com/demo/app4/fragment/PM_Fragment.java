package com.demo.app4.fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.app4.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class PM_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(
                R.layout.fragment_portrait_mode,
                container,
                false);
    }


}
