package com.bridgelabz.databindingpractice2;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridgelabz.databindingpractice2.databinding.RecylerDatabindingBinding;

import java.util.List;

/**
 * Created by bridgelabz1 on 2/7/16.

 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyviewHolder>  {


   Context mcontext;
    List<UserModel> list;

    public RecyclerviewAdapter(Context mcontext, List<UserModel> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecylerDatabindingBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.recyler_databinding,parent,false);
        return new MyviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
     holder.bindconnection(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        RecylerDatabindingBinding binding;

        public MyviewHolder(RecylerDatabindingBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        void bindconnection(UserModel model) {
        binding.setUser(model);
        }
    }
}