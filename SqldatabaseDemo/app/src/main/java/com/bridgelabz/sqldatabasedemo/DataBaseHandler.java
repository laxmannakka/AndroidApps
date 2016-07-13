package com.bridgelabz.sqldatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz1 on 8/6/16.
 */
public class DataBaseHandler extends SQLiteOpenHelper{
        // Data base Name
        public static String DATABASE_NAME = "ContactManager";
    // Table Name
    public static String TABLE_NAME = "contacts";
    //  contact names and columns
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    // Data base Name
    public static int DATABASE_NUMBER = 2;


    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT not null,"
                + KEY_PH_NO + " TEXT not null" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);

    }
    void addContactToDataBase(ContactModel contacts)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName()); // Contact Name
        values.put(KEY_PH_NO, contacts.getNumber()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_NAME,null, values);
        db.close(); // Closing database connection
    }

    // Getting All Contacts
    public List<ContactModel > getAllContacts() {

        List<ContactModel> contactList = new ArrayList<ContactModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ContactModel contact = new ContactModel();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public Integer deletedata(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,KEY_ID+"="+id,null);
    }
    public Integer updateContact(String id,String newName,String newMobile ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, newName);
        values.put(KEY_PH_NO, newMobile);


       return db.update(TABLE_NAME, values, KEY_ID+"=" +id, null);
        // updating row
        /*return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });*/
    }
}

