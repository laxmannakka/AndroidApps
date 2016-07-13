package com.bridgelabz.indianpremiearleageemvvm.controller;

import com.bridgelabz.indianpremiearleageemvvm.iplteamviewmodel.PlayerinfoViewmodel;
import com.bridgelabz.indianpremiearleageemvvm.model.PlayerInfo;
import com.bridgelabz.indianpremiearleageemvvm.view.IplPlayersview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz1 on 8/7/16.
 */


// this Controller takes Model class Stores the data to viewmodel class
public class IplPlayerinfoController {

    public static ArrayList setPlayersInfo(List<PlayerInfo> model) {
         String BASE_URL = "http://192.168.0.132/laxman/";

        ArrayList<PlayerinfoViewmodel> playerviewmodel = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            PlayerInfo mPlayerData = model.get(i);
            String name = mPlayerData.getPlayername();
            String role = mPlayerData.getRole();
            String BatStyle = mPlayerData.getBattingStyle();
            String BowlStyle = mPlayerData.getBowlingStyle();
            String nationality = mPlayerData.getNationality();
            String dob = mPlayerData.getDob();
            String uri = mPlayerData.getUrl();
            String url= BASE_URL+uri;
            playerviewmodel.add(new PlayerinfoViewmodel(name, role, BatStyle, BowlStyle, nationality, dob, url));

        }

    return playerviewmodel;
    }
}
