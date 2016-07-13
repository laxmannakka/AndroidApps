package com.bridgelabz.mvcpracticeexrcise.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bridgelabz.mvcpracticeexrcise.R;
import com.bridgelabz.mvcpracticeexrcise.model.Model;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by bridgelabz1 on 27/6/16.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {
    List<Model> total_list;

    public ModelAdapter(List<Model> total_list) {
        this.total_list = total_list;
    }

    @Override
    public ModelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
        itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.data,parent,false);
        return new MyViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(ModelAdapter.MyViewHolder holder, int position) {
        Model model = total_list.get(position);
        holder.name.setText(model.getName());
        holder.Id.setText(model.getId());
        holder.Role.setText(model.getRole());

    }

    @Override
    public int getItemCount() {
        return total_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,Id,Role;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            Id =(TextView)itemView.findViewById(R.id.id);
            Role =(TextView)itemView.findViewById(R.id.role);


        }
    }
}
