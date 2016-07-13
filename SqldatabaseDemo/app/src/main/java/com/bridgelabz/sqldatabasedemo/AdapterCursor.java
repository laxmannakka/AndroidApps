package com.bridgelabz.sqldatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 *
 * Created by bridgelabz1 on 8/6/16.
 */

public class AdapterCursor extends BaseAdapter{

    public class ContactViewHolder  {
        public TextView name;
        public  TextView id;
        public TextView mobile_number;
        }
    List<ContactModel> contactsInfo;
    LayoutInflater inflater;
    Context mContext;

    public AdapterCursor(List<ContactModel> contactsInfo,  Context mContext) {
        this.contactsInfo = contactsInfo;
        inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
         return contactsInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return contactsInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactViewHolder viewHolder;
        if(convertView == null)
        {

            convertView = inflater.inflate(R.layout.listview,parent,false);
            viewHolder = new ContactViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.thistext1);
            viewHolder.id = (TextView) convertView.findViewById(R.id.id);
            viewHolder.mobile_number = (TextView) convertView.findViewById(R.id.num) ;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ContactViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(contactsInfo.get(position).getName());
        viewHolder.mobile_number.setText(contactsInfo.get(position).getNumber());
        viewHolder.id.setText(contactsInfo.get(position).getId());

        return convertView;
    }
}
