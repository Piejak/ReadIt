package com.bpiejak.readit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Brian on 3/22/2016.
 */
public class All extends Fragment {
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        return layoutInflater.inflate(R.layout.all, container, false);
    }
}
