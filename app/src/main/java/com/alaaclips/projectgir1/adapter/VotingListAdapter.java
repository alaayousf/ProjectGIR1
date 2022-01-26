package com.alaaclips.projectgir1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaaclips.projectgir1.R;
import com.alaaclips.projectgir1.model.VotingList;

import java.util.ArrayList;
import java.util.List;

public class VotingListAdapter extends RecyclerView.Adapter<VotingListAdapter.VotingListViewHolde> {

     ArrayList<VotingList> mData;
     Activity activity;


    public VotingListAdapter(ArrayList<VotingList> mData, Activity activity) {
        this.mData = mData;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VotingListViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(activity).inflate(R.layout.list_item,parent,false);
        return new VotingListViewHolde(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull VotingListViewHolde holder, int position) {
        holder.myTextView.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class VotingListViewHolde extends RecyclerView.ViewHolder{

        TextView myTextView;


        public VotingListViewHolde(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.list_titel);

        }
    }
}



