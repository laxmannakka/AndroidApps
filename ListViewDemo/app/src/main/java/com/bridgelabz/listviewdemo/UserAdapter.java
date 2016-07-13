package com.bridgelabz.listviewdemo;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bridgelabz1 on 6/6/16.
 */
public class UserAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<UserInfo> userInfos;
    LayoutInflater inflater;

    public UserAdapter(Context mContext, ArrayList<UserInfo> userInfos) {
        this.mContext = mContext;
        this.userInfos = userInfos;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return userInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.design,parent,false);
        TextView firstName;
        TextView lastName;

        firstName=(TextView) convertView.findViewById(R.id.edit);
        lastName =(TextView)convertView.findViewById(R.id.textView);
        firstName.setText(userInfos.get(position).getName());
        lastName.setText(userInfos.get(position).getSurname());

        return convertView;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VIewHolder viewholder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.design, parent, false);
            viewholder = new VIewHolder();
            viewholder.name = (TextView) convertView.findViewById(R.id.edit);
            viewholder.surname = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewholder);
        } else {
            viewholder = (VIewHolder) convertView.getTag();
        }

        viewholder.name.setText(userInfos.get(position).getName());
        viewholder.surname.setText(userInfos.get(position).getSurname());
        return convertView;
    }


}





