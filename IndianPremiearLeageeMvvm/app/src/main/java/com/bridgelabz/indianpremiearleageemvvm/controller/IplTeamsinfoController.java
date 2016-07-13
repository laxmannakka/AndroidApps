package com.bridgelabz.indianpremiearleageemvvm.controller;

import android.graphics.Bitmap;

import com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel.IplTeamsinfoViewmodel;
import com.bridgelabz.indianpremiearleageemvvm.model.IplTeamsinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz1 on 7/7/16.
 */

public class IplTeamsinfoController {


    public static  ArrayList  setViewModel(List<IplTeamsinfo> mteammemberslist){
        ArrayList<IplTeamsinfoViewmodel> viewmodellist;
        viewmodellist = new ArrayList<>();

        IplTeamsinfoViewmodel obj = new IplTeamsinfoViewmodel();

        for(int i=0; i< mteammemberslist.size();i++){
            IplTeamsinfo getSingleteam = mteammemberslist.get(i);
           String  Teamname = getSingleteam.getmTeamname();
            String OwnerName=getSingleteam.getOwner();
            String url = getSingleteam.getUrl();


            viewmodellist.add(new IplTeamsinfoViewmodel(Teamname,OwnerName,url));

        }

        return  viewmodellist;

    }
}
