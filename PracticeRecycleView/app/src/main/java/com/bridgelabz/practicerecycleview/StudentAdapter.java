package com.bridgelabz.practicerecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bridgelabz1 on 14/6/16.
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    private List<StudentData> studentdata;

    public StudentAdapter(List<StudentData> studentdata) {
        this.studentdata = studentdata;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Id,Subject;
        public MyViewHolder(View itemView) {
            super(itemView);
            Name = (TextView)itemView.findViewById(R.id.name);
            Id  =(TextView)itemView.findViewById(R.id.id);
            Subject =(TextView)itemView.findViewById(R.id.subject);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewlist = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentdata,parent,false);
        return new MyViewHolder(viewlist);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StudentData student = studentdata.get(position);
        holder.Name.setText(student.getName());
        holder.Id.setText(student.getId());
        holder.Subject.setText(student.getSubject());




    }

    @Override
    public int getItemCount() {

        return studentdata.size();
    }






}
