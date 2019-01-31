package com.example.applicationradio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class dbase extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "station";
    private static final String TABLE_PERSON = "stations";
    private static final String KEY_ID = "id_st";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESC = "descr";
    private static final String KEY_URL = "url";
    private static final String KEY_LOGO = "logo";
    public dbase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "create table stations ( id_st INTEGER PRIMARY KEY, name TEXT , descr TEXT , url TEXT , logo TEXT)";
        db.execSQL(CREATE_PERSON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);
    }

    public boolean insert_station(ContentValues contentValues){
        SQLiteDatabase db=getWritableDatabase();

        long res=db.insert(TABLE_PERSON, null, contentValues);
        db.close();
        if (res!=-1) return true;
        else return false;


    }
}
