package com.bridgelabz.asyntaskjson2;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bridgelabz1 on 22/6/16.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {


    private List<Player> playerlist;
    Context mcontext;

    public PlayerAdapter( Context mcontext,List<Player> playerlist) {
        this.playerlist = playerlist;
        this.mcontext = mcontext;

    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Position;
        ImageView Image;
        public MyViewHolder(View itemView) {
            super(itemView);
            Name = (TextView)itemView.findViewById(R.id.name);
             Position =(TextView)itemView.findViewById(R.id.position);
            Image =(ImageView)itemView.findViewById(R.id.image);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View displayplayersdata = LayoutInflater.from(parent.getContext()).inflate(R.layout.playerdata,parent,false);
        return new MyViewHolder(displayplayersdata);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    Player singleplayerdata = playerlist.get(position);
        holder.Name.setText(singleplayerdata.getName());
        holder.Position.setText(singleplayerdata.getPosition());
        holder.Image.setImageBitmap(singleplayerdata.getPhoto());

    }

    @Override
    public int getItemCount() {
        return playerlist.size();
    }



}
