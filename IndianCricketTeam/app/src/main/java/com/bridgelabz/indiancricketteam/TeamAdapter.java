package com.bridgelabz.indiancricketteam;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bridgelabz1 on 23/6/16.
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder>{

      List<ModelTeamPlayer> model;

    public TeamAdapter(List<ModelTeamPlayer> model) {
        this.model = model;
    }

    @Override
    public TeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.teamdisplaydata,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(TeamAdapter.MyViewHolder holder, int position) {
        ModelTeamPlayer team = model.get(position);
        holder.playername.setText(team.getName());
        holder.role.setText(team.getRole());
        holder.battingstyle.setText(team.getBatstyle());
        holder.bowlingstyle.setText(team.getBowlstyle());
        holder.image.setImageBitmap(team.getImage());


    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView playername,role,battingstyle,bowlingstyle;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            playername = (TextView) (itemView).findViewById(R.id.setnameTextview);
            role =(TextView)(itemView).findViewById(R.id.setplayrole);
            battingstyle = (TextView)(itemView).findViewById(R.id.setbattingstyle);
            bowlingstyle =(TextView)(itemView).findViewById(R.id.setbowl);
            image = (ImageView) (itemView).findViewById(R.id.imageview);
        }
    }
}


