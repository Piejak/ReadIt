package com.bpiejak.readit;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.BroadcastReceiver;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.daimajia.swipe.implments.SwipeItemAdapterMangerImpl;
import com.daimajia.swipe.implments.SwipeItemMangerImpl;
import com.daimajia.swipe.interfaces.SwipeAdapterInterface;

import java.util.Locale;

public class CustomAdapter extends RecyclerSwipeAdapter<CustomAdapter.ViewHolder> implements SwipeAdapterInterface{
    private Post[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        SwipeLayout swipeLayout;
        public TextView mOpView;
        public TextView mLinkView;
        public TextView mUpvotesView;
        public TextView mDownvotesView;
        public ImageButton mUpvoteButton;
        public ImageButton mDownvoteButton;
        public ImageButton mSaveButton;
        public ImageButton mCommentsButton;


        public ViewHolder(final View postView) {
            super(postView);
            swipeLayout = (SwipeLayout) postView.findViewById(R.id.swipe_layout);
            mOpView = (TextView) postView.findViewById(R.id.op);
            mLinkView = (TextView) postView.findViewById(R.id.link);
            mUpvotesView = (TextView) postView.findViewById(R.id.upvotes);
            mDownvotesView = (TextView) postView.findViewById(R.id.downvotes);
            mUpvoteButton = (ImageButton) postView.findViewById(R.id.upvote_button);
            mDownvoteButton = (ImageButton) postView.findViewById(R.id.downvote_button);
            mSaveButton = (ImageButton) postView.findViewById(R.id.save_button);
            mCommentsButton = (ImageButton) postView.findViewById(R.id.comments_button);
        }

    }

    public CustomAdapter(Post[] dataset) {
        this.mDataset = dataset;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_layout,
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

        holder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            
        });
        holder.mUpvoteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mItemManger.closeItem(position);
                Toast.makeText(holder.itemView.getContext(), "Upvote", Toast.LENGTH_SHORT).show();
            }
        });
        holder.mDownvoteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mItemManger.closeItem(position);
                Toast.makeText(holder.itemView.getContext(), "Downvote", Toast.LENGTH_SHORT).show();
            }
        });
        holder.mSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mItemManger.closeItem(position);
                Toast.makeText(holder.itemView.getContext(), "Save", Toast.LENGTH_SHORT).show();
            }
        });
        holder.mCommentsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mItemManger.closeItem(position);
                Toast.makeText(holder.itemView.getContext(), "Comments", Toast.LENGTH_SHORT).show();
            }
        });
        mItemManger.bindView(holder.itemView, position);
    }
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe_layout;
    }
}
