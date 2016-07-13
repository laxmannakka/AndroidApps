package com.bridgelabz.ipldemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridgelabz.ipldemo.R;

/**
 * Created by bridgelabz1 on 29/6/16.
 */

public class Franchies extends android.support.v4.app.Fragment{
    public Franchies() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.franchies,container,false);
    }

    /**
     * Created by bridgelabz1 on 29/6/16.
     */

    public static class ListofTeams extends android.support.v4.app.Fragment {
        public ListofTeams() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return  inflater.inflate(R.layout.listofteams,container,false);
        }
    }
}
