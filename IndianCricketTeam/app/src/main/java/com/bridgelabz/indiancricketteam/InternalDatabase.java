package com.bridgelabz.indiancricketteam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

/**
 * Created by bridgelabz1 on 24/6/16.
 */

public class InternalDatabase extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "Mydatabase";
    public static String TABLE_NAME ="playerlist";
    public static String KEY_ID ="1";
    public static int DATA_BASE_NUMBER =1;



    public InternalDatabase(Context context) {
        super(context, DATABASE_NAME, null,DATA_BASE_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_teamlist = "CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY, "+Keyconstant.KEY_NAME+" TEXT not null,"+Keyconstant.KEY_PLAYROLE+" TEXT not null,"

                +Keyconstant.KEY_BATTINGSTYLE+" TEXT not null ,"+ Keyconstant.KEY_BOWLINGSTYLE+" TEXT not null"+");";
        db.execSQL(Create_teamlist);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void adddatatoDatabase(ModelTeamPlayer obj){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues storedata = new ContentValues();
        storedata.put(Keyconstant.KEY_NAME ,obj.getName());
        storedata.put(Keyconstant.KEY_PLAYROLE,obj.getRole());
        storedata.put(Keyconstant.KEY_BATTINGSTYLE,obj.getBatstyle());
        storedata.put(Keyconstant.KEY_BOWLINGSTYLE,obj.getBowlstyle());
        db.insert(TABLE_NAME,null,storedata);
        db.close();
    }


}
