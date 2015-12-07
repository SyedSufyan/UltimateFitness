package com.cs442.uf.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class Histogram extends AppCompatActivity {

    private String userName;
    private Date date;
    private Double height;
    private Double weight;
    private int age;
    private char gender;
    private double waist;
    private double wrist;
    private double forearm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histogram);
    }
}
