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


    private static final int DATABASE_VERSION = 3;
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
    private static final String COLUMN_HIP = "hip";
    private static final String COLUMN_FOREARM = "forearm";
    private static final String COLUMN_RBMI = "rbmi";
    private static final String COLUMN_RBMR = "rbmr";
    private static final String COLUMN_RBFP = "rbfp";


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
                    COLUMN_HIP + " name text not null," +
                    COLUMN_FOREARM + " name text not null," +
                    COLUMN_RBMI + " name text not null," +
                    COLUMN_RBMR + " name text not null," +
                    COLUMN_RBFP + " name text not null);";


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
        values.put(COLUMN_HIP, histogramObj.getHip());
        values.put(COLUMN_FOREARM, histogramObj.getForearm());
        values.put(COLUMN_RBMI,histogramObj.getRbmi());
        values.put(COLUMN_RBMR,histogramObj.getRbmr());
        values.put(COLUMN_RBFP,histogramObj.getRbfp());

        System.out.println ("++Insert " +  values);
        db.insert(HISTOGRAM_TABLE_NAME, null, values);
        db.close();

    }

    public List<HistogramObject> getAll(String userName)
    {
        List <HistogramObject> list = null;
        //List<HistogramObject> comments = new ArrayList<HistogramObject>();
        db = this.getReadableDatabase();
        /*String[] projection = {
                COLUMN_ID,
                COLUMN_UNAME,
                COLUMN_DATE,
                COLUMN_HEIGHT,
                COLUMN_AGE,
                COLUMN_GENDER,
                COLUMN_WEIGHT,
                COLUMN_WAIST,
                COLUMN_WRIST,
                COLUMN_HIP,
                COLUMN_FOREARM,
                COLUMN_RBMI,
                COLUMN_RBMR,
                COLUMN_RBFP
        };
        Cursor cursor = db.query(HISTOGRAM_TABLE_NAME, projection_)*/
        Cursor cursor = db.rawQuery("SELECT * FROM " + HISTOGRAM_TABLE_NAME + " WHERE " + COLUMN_UNAME + " = '"+userName+"'", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {



            HistogramObject aux = new HistogramObject();


           /* String name = cursor.getString(cursor
                    .getColumnIndex(countyname));

            list.add(name);*/
           /* COLUMN_UNAME,
                    COLUMN_DATE,
                    COLUMN_HEIGHT,
                    COLUMN_AGE,
                    COLUMN_GENDER,
                    COLUMN_WEIGHT,
                    COLUMN_WAIST,
                    COLUMN_WRIST,
                    COLUMN_HIP,
                    COLUMN_FOREARM,
                    COLUMN_RBMI,
                    COLUMN_RBMR,
                    COLUMN_RBFP*/

            /*String results = "* ";
            results.concat("id -> " + cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_ID)
            ));
            results.concat("date -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_DATE)
            ));
            results.concat("height -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_HEIGHT)
            ));
            results.concat("age -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_AGE)
            ));
            results.concat("gender -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_GENDER)
            ));
            results.concat("wrist -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_WEIGHT)
            ));
            results.concat("weight -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_WAIST)
            ));
            results.concat("wrist -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_WRIST)
            ));
            results.concat("hip -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_HIP)
            ));
            results.concat("forearm -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_FOREARM)
            ));
            results.concat("rbmr -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_RBMI)
            ));
            results.concat("rbmi -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_RBMR)
            ));
            results.concat("rbmr -> " + cursor.getLong(
                    cursor.getColumnIndexOrThrow(COLUMN_RBFP)
            ));*/

            //System.out.println(results);

           /* results.concat("userName -> " + cursor.getString(1));
            results.concat("date -> " + cursor.getString(2));
            results.concat("age -> " + cursor.getInt(3));
            results.concat("weight -> " + cursor.getDouble(4));
            results.concat("height -> " + cursor.getDouble(5));
            results.concat("gender -> " + cursor.getString(6));
            results.concat("waist -> " + cursor.getDouble(7));
            results.concat("wrist -> " + cursor.getDouble(8));
            results.concat("forearm -> " + cursor.getDouble(9));*/

            /*values.put(COLUMN_ID, count);

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
        values.put(COLUMN_HIP, histogramObj.getHip());
        values.put(COLUMN_FOREARM, histogramObj.getForearm());
        values.put(COLUMN_RBMI,histogramObj.getRbmi());
        values.put(COLUMN_RBMR,histogramObj.getRbmr());
        values.put(COLUMN_RBFP,histogramObj.getRbfp());*/


            aux.setUserName(cursor.getString(1));
            //aux.setDate(format.parse(cursor.getString(1)));
            aux.setHeight(Double.parseDouble(cursor.getString(3)));
            aux.setAge(Integer.parseInt(cursor.getString(4)));
            aux.setGender(cursor.getString(5));
            aux.setWeight(Double.parseDouble(cursor.getString(6)));
            aux.setWaist(Double.parseDouble(cursor.getString(7)));
            aux.setWrist(Double.parseDouble(cursor.getString(8)));
            aux.setHip(Double.parseDouble(cursor.getString(9)));
            aux.setForearm(Double.parseDouble(cursor.getString(10)));
            aux.setRbmi(Double.parseDouble(cursor.getString(11)));
            aux.setRbmr(Double.parseDouble(cursor.getString(12)));
            aux.setRbfp(Double.parseDouble(cursor.getString(13)));

            list.add(aux);

            System.out.println("*** Count: " + cursor.getColumnCount() + "; content -> " +
                     "id: " + cursor.getString(0) + "; " +
                     "userName: " +cursor.getString(1) + "; " +
                     "date: " +cursor.getString(2) + "; " +
                     "height: " +cursor.getString(3) + "; " +
                     "age: " +cursor.getString(4) + "; " +
                     "gender: " +cursor.getString(5) + "; " +
                     "weight: " +cursor.getString(6) + "; " +
                     "waist: " +cursor.getString(7) + "; " +
                     "wrist: " +cursor.getString(8) + "; " +
                     "hip: " +cursor.getString(9) + "; " +
                     "forearm: " +cursor.getString(10) + "; " +
                     "rbmi: " +cursor.getString(11) + "; " +
                     "rbmr: " +cursor.getString(12) + "; " +
                     "rbfp: " +cursor.getString(13) + "; "
            );
            /*values.put(COLUMN_DATE, date);
            values.put(COLUMN_AGE, histogramObj.getAge());
            values.put(COLUMN_WEIGHT, histogramObj.getWeight());
            values.put(COLUMN_HEIGHT, histogramObj.getHeight());
            values.put(COLUMN_GENDER, histogramObj.getGender());
            values.put(COLUMN_WAIST, histogramObj.getWaist());
            values.put(COLUMN_WRIST, histogramObj.getWrist());
            values.put(COLUMN_HIP, histogramObj.getHip());
            values.put(COLUMN_FOREARM, histogramObj.getForearm());
            values.put(COLUMN_RBMI,histogramObj.getRbmi());
            values.put(COLUMN_RBMR,histogramObj.getRbmr());
            values.put(COLUMN_RBFP,histogramObj.getRbfp());*/
            cursor.moveToNext();
            /*HistogramObject histogramAux =
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();*/
        }
            //HistogramObject test = new HistogramObject();

        return list;
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
        System.out.println("**Upgrading database");
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        String query2 = "DROP TABLE IF EXISTS "+ HISTOGRAM_TABLE_NAME;
        db.execSQL(query);
        db.execSQL(query2);
        this.onCreate(db);
    }
}
