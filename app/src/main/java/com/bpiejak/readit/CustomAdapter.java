package com.bpiejak.readit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Brian on 3/23/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Post[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mOpView;
        public TextView mLinkView;
        public TextView mUpvotesView;
        public TextView mDownvotesView;


        public ViewHolder(View postView) {
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i(mDataset[position].getLink(), mDataset[position].getLink());
        int numDownVotes = mDataset[position].getDownvotes();
        int numUpVotes = mDataset[position].getUpvotes();
        holder.mOpView.setText(mDataset[position].getOp());
        holder.mLinkView.setText(mDataset[position].getLink());
        holder.mDownvotesView.setText(mDataset[position].getDownvotes() + "");
        holder.mUpvotesView.setText(mDataset[position].getUpvotes() + "");
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
