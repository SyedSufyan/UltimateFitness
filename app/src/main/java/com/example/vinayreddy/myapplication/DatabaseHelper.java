package com.example.vinayreddy.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinay reddy on 11/23/2015.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "fitness.db";
    private static final String TABLE_NAME = "contacts";
    private static final String HISTOGRAM_TABLE_NAME = "histogram";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_UNAME = "uname";

    /* Columns for login table */
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "pass";

    private static final String TABLE_CREATE = "create table fitness.db (id integer primary key not null, " +
            "name text not null, email text not null, uname text not null, pass text not null);";

    /* Column for histogram table */
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_GENDER= "gender";
    private static final String COLUMN_WAIST = "waist";
    private static final String COLUMN_WRIST = "wrist";
    private static final String COLUMN_FOREARM = "forearm";

    private static final String HISTOGRAM_TABLE_CREATE =
            "create table " + HISTOGRAM_TABLE_NAME + " ( " +
                    COLUMN_ID + " integer primary key not null, " +
                    COLUMN_DATE + " name text not null, " +
                    COLUMN_HEIGHT + " name text not null, " +
                    COLUMN_AGE + " name text not null, " +
                    COLUMN_GENDER + " name text not null, " +
                    COLUMN_WEIGHT + " name text not null, " +
                    COLUMN_WAIST + " name text not null, " +
                    COLUMN_WRIST + " name text not null, " +
                    COLUMN_FOREARM + " name text not null);";

    private SQLiteDatabase db;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(HISTOGRAM_TABLE_CREATE);
        this.db = db;
    }

    public void insertInHistogram(HistogramObject histogramObj)
    {

    }

    public void insertContact(Contact c){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "select uname, pass from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        String a,b;
        b = "not found";

        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);

                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }

            } while (cursor.moveToNext());
        }
        return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
