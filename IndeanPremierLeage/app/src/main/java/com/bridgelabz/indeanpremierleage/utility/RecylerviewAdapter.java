package com.bridgelabz.indeanpremierleage.utility;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.indeanpremierleage.R;
import com.bridgelabz.indeanpremierleage.model.TotalNumberofTeams;

import java.util.List;

/**
 * Created by bridgelabz1 on 6/7/16.
 */

public class RecylerviewAdapter extends RecyclerView.Adapter<RecylerviewAdapter.MyViewHolder> {
        private List<TotalNumberofTeams> teamnames;

    public RecylerviewAdapter(List<TotalNumberofTeams> teamnames) {
        this.teamnames = teamnames;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView teamName,teamowner;
            ImageView logo;
            public MyViewHolder(View itemView) {
                super(itemView);
                teamName = (TextView)itemView.findViewById(R.id.teamname);
                teamowner  =(TextView)itemView.findViewById(R.id.owner);
                logo = (ImageView)itemView.findViewById(R.id.logo);

            }
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View viewlist = LayoutInflater.from(parent.getContext()).inflate(R.layout.teamnames,parent,false);
            return new MyViewHolder(viewlist);
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
             TotalNumberofTeams obj= teamnames.get(position);
            holder.teamName.setText(obj.getmTeamname());
            holder.teamowner.setText(obj.getOwner());
            holder.logo.setImageBitmap(obj.getImage());
        }

        @Override
        public int getItemCount() {

            return teamnames.size();
        }



    }
