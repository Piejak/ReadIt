package com.bpiejak.readit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by brian_000 on 3/21/2016.
 */
public class FrontPage extends Fragment {
    private static final int DATASET_COUNT = 30;

    private SwipeRefreshLayout swipeRefreshLayout;

    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected RecyclerView.Adapter mAdapter;
    protected Post[] mDataset;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initDataset();
        View rootView = inflater.inflate(R.layout.front_page, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.front_page_recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new CustomAdapter(mDataset);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.front_page_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Refreshed", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent, R.color.primary);

        return rootView;
    }

    private void initDataset() {
        mDataset = new Post[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = new Post(420, 69, "Someone", "imgur.com/bpiesa");
        }
    }
}
