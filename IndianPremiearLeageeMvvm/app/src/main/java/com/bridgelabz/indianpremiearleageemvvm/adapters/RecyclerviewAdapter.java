package com.bridgelabz.indianpremiearleageemvvm.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridgelabz.indianpremiearleageemvvm.R;
import com.bridgelabz.indianpremiearleageemvvm.databinding.TeamsinfobindingBinding;
import com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel.IplTeamsinfoViewmodel;

import android.databinding.DataBindingUtil;

import java.util.List;

/**
 * Created by bridgelabz1 on 7/7/16.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    List<IplTeamsinfoViewmodel> recyclerviewmodel;
    Context mcontext;

    public RecyclerviewAdapter(List<IplTeamsinfoViewmodel> recyclerviewmodel, Context mcontext) {
        this.recyclerviewmodel = recyclerviewmodel;
        this.mcontext = mcontext;
    }

    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TeamsinfobindingBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.teamsinfobinding, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.MyViewHolder holder, int position) {

        // calling the function for set the data
        holder.bindconnection(recyclerviewmodel.get(position));

    }

    @Override
    public int getItemCount() {
        return recyclerviewmodel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TeamsinfobindingBinding binding;


        public MyViewHolder(TeamsinfobindingBinding itemview) {
            super(itemview.getRoot());
            binding = itemview;
        }

        void bindconnection(IplTeamsinfoViewmodel model) {

            binding.setTeamsData(model);

        }
    }


}



