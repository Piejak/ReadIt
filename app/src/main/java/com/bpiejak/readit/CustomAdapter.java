package com.bpiejak.readit;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.BroadcastReceiver;

import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Post[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mOpView;
        public TextView mLinkView;
        public TextView mUpvotesView;
        public TextView mDownvotesView;


        public ViewHolder(final View postView) {
            super(postView);

            mOpView = (TextView) postView.findViewById(R.id.op);
            mLinkView = (TextView) postView.findViewById(R.id.link);
            mUpvotesView = (TextView) postView.findViewById(R.id.upvotes);
            mDownvotesView = (TextView) postView.findViewById(R.id.downvotes);
        }

    }

    public CustomAdapter(Post[] dataset) {
        this.mDataset = dataset;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view,
                parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mOpView.setText(mDataset[position].getOp());
        holder.mLinkView.setText(mDataset[position].getLink());
        holder.mDownvotesView.setText(String.format(Locale.ENGLISH, "%d",
                mDataset[position].getDownvotes()));
        holder.mUpvotesView.setText(String.format(Locale.ENGLISH, "%d",
                mDataset[position].getUpvotes()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), mDataset[position].getLink(), Toast.LENGTH_SHORT).show();
                new WebViewBroadcaster(mDataset[position].getLink());
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
