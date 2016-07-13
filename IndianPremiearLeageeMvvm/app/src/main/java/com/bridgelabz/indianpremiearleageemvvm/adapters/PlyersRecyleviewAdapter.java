package com.bridgelabz.indianpremiearleageemvvm.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridgelabz.indianpremiearleageemvvm.R;
import com.bridgelabz.indianpremiearleageemvvm.databinding.PlayersinfoBinding;
import com.bridgelabz.indianpremiearleageemvvm.databinding.TeamsinfobindingBinding;
import com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel.IplTeamsinfoViewmodel;
import com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel.PlayerinfoViewmodel;
import com.bridgelabz.indianpremiearleageemvvm.model.IplTeamsinfo;
import com.bridgelabz.indianpremiearleageemvvm.view.IplPlayersview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz1 on 8/7/16.
 */

public class PlyersRecyleviewAdapter extends RecyclerView.Adapter<PlyersRecyleviewAdapter.MyViewHolder> {

    Context mcontext;
    List<PlayerinfoViewmodel> recycleviewModel;

    public PlyersRecyleviewAdapter(Context mcontext, List<PlayerinfoViewmodel> recycleviewModel) {
        this.mcontext = mcontext;
        this.recycleviewModel = recycleviewModel;
    }

    @Override
    public PlyersRecyleviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        PlayersinfoBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.playersinfo, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(PlyersRecyleviewAdapter.MyViewHolder holder, int position) {

        holder.bindconnection(recycleviewModel.get(position));
    }

    @Override
    public int getItemCount() {
        return recycleviewModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        PlayersinfoBinding binding;
        public MyViewHolder(PlayersinfoBinding itemView) {
            super(itemView.getRoot());
        this.binding =itemView;
        }

        public void  bindconnection (PlayerinfoViewmodel model){

            binding.setPlayer(model);
        }

    }

}
