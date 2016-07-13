package com.bridgelabz.practicelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by bridgelabz1 on 13/6/16.
 */
public class UserAdapter extends BaseAdapter {

    Context context;
    ArrayList<Employee> data;
    LayoutInflater inflater;

    public UserAdapter(Context context, ArrayList<Employee> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewholder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.displaylist, parent, false);
            viewholder = new ViewHolder();
            viewholder.Name = (TextView) convertView.findViewById(R.id.name);
            viewholder.Id = (TextView) convertView.findViewById(R.id.id);
            viewholder.Designation = (TextView) convertView.findViewById(R.id.designation);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        viewholder.Name.setText(data.get(position).getName());
        viewholder.Id.setText(data.get(position).getId());
        viewholder.Designation.setText(data.get(position).getDesignation());


        return convertView;
    }
}
