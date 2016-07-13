package com.bridgelabz.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by bridgelabz1 on 3/6/16.
 */
public class FragmentOne extends Fragment {

    ListView listView;
    String[] versions;
     ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.firstfragment,container,false);

        listView = (ListView) view.findViewById(R.id.list);
        versions =getResources().getStringArray(R.array.android_versions);
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.listview,R.id.row,versions);

        listView.setAdapter(adapter);

        return view;
    }
}
