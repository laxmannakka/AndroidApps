package com.bridgelabz.mvcpracticeexrcise.controller;

import android.util.Log;

import com.bridgelabz.mvcpracticeexrcise.model.Model;

import java.util.ArrayList;

/**
 * Created by bridgelabz1 on 27/6/16.
 */

public class Controller {

    public ArrayList<Model> arrayList = new ArrayList<>();
     public Model model=new Model();

    public  ArrayList<Model> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
    }


    public void setdata(){
        model.setId("1");
        model.setName("laxman");
        model.setRole("Android_Developer");
        arrayList.add(model);
    }
    public void getdata(){
       Log.i("Tag", model.getId());
        Log.i("TAg",model.getName());
        Log.i("TAG",model.getRole());

    }

}
