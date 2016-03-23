package com.bpiejak.readit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brian_000 on 3/21/2016.
 */
public class FrontPage extends Fragment {
    private static final int DATASET_COUNT = 30;

    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected RecyclerView.Adapter mAdapter;
    protected Post[] mDataset;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all, container, false);
//        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.front_page_recycler);
//        mLayoutManager = new LinearLayoutManager(getActivity());
//        mAdapter = new CustomAdapter(mDataset);
//        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        initDataset();
    }

    private void initDataset() {
        mDataset = new Post[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = new Post(420, 69, "Someone", "imgur.com/bpiesa");
        }
    }
}
