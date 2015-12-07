package com.cs442.uf.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import org.w3c.dom.Comment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (id integer primary key not null, " +
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
                    COLUMN_UNAME + " name text not null, " +
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
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + HISTOGRAM_TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);

        values.put(COLUMN_UNAME, histogramObj.getUserName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(histogramObj.getDate());

        values.put(COLUMN_DATE, date);
        values.put(COLUMN_AGE, histogramObj.getAge());
        values.put(COLUMN_WEIGHT, histogramObj.getWeight());
        values.put(COLUMN_HEIGHT, histogramObj.getHeight());
        values.put(COLUMN_GENDER, histogramObj.getGender());
        values.put(COLUMN_WAIST, histogramObj.getWaist());
        values.put(COLUMN_WRIST, histogramObj.getWrist());
        values.put(COLUMN_FOREARM, histogramObj.getForearm());

        System.out.println ("++Insert " +  values);
        db.insert(HISTOGRAM_TABLE_NAME, null, values);
        db.close();

    }

    public HistogramObject getAll(String userName)
    {
        List<HistogramObject> comments = new ArrayList<HistogramObject>();
        db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + HISTOGRAM_TABLE_NAME + " WHERE " + COLUMN_UNAME + " = '"+userName+"'", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            List <String> list = null;
           /* String name = cursor.getString(cursor
                    .getColumnIndex(countyname));

            list.add(name);*/

            /*String results = "* ";
            results.concat("id -> " + cursor.getLong(0));
            results.concat("userName -> " + cursor.getString(1));
            results.concat("date -> " + cursor.getString(2));
            results.concat("age -> " + cursor.getInt(3));
            results.concat("weight -> " + cursor.getDouble(4));
            results.concat("height -> " + cursor.getDouble(5));
            results.concat("gender -> " + cursor.getString(6));
            results.concat("waist -> " + cursor.getDouble(7));
            results.concat("wrist -> " + cursor.getDouble(8));
            results.concat("forearm -> " + cursor.getDouble(9));*/
            System.out.println("*** Count: " + cursor.getColumnCount() + "; content -> " +
                    cursor.getString(0) + "; " +
                    cursor.getString(1) + "; " +
                    cursor.getString(2) + "; " +
                    cursor.getString(3) + "; " +
                    cursor.getString(4) + "; " );

            cursor.moveToNext();
            /*HistogramObject histogramAux =
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();*/
        }
            HistogramObject test = new HistogramObject();

        return test;
    }

    /*values.put(COLUMN_ID, count);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(histogramObj.getDate());

    values.put(COLUMN_DATE, date);
    values.put(COLUMN_AGE, histogramObj.getAge());
    values.put(COLUMN_WEIGHT, histogramObj.getWeight());
    values.put(COLUMN_HEIGHT, histogramObj.getHeight());
    values.put(COLUMN_GENDER, Character.toString(histogramObj.getGender()));
    values.put(COLUMN_WAIST, histogramObj.getWaist());
    values.put(COLUMN_WRIST, histogramObj.getWrist());
    values.put(COLUMN_FOREARM, histogramObj.getForearm());*/

    //Cursor c = db.rawQuery("SELECT * FROM tbl1 WHERE name = '"+name+"'", null);


    /*private Comment cursorToHistogram(Cursor cursor) {
        HistogramObject histogramObj = new HistogramObject();

        histogramObj.set
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }*/


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
