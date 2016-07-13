package com.bridgelabz.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by bridgelabz1 on 20/6/16.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {


    private List<Employee> employeslist;


    public EmployeeAdapter(List<Employee> employeslist) {
        this.employeslist = employeslist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Id,Desig;
        public MyViewHolder(View itemView) {
            super(itemView);
           Name = (TextView) itemView.findViewById(R.id.name);
            Id =(TextView)itemView.findViewById(R.id.id);
            Desig =(TextView)itemView.findViewById(R.id.designation);
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.employeelist,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Employee employee = employeslist.get(position);
        holder.Name.setText(employee.getName());
        holder.Id.setText(employee.getId());
        holder.Desig.setText(employee.getDesignation());


    }

    @Override
    public int getItemCount() {
       return employeslist.size();
    }


}

