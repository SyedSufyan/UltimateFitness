package com.cs442.uf.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by vinay reddy on 11/23/2015.
 */

public class Display extends Activity {

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String username = getIntent().getStringExtra("username");

        TextView tv = (TextView)findViewById(R.id.eUsername);
        tv.setText(username);

        final Button buttonVit = (Button) findViewById(R.id.button_vitals);
        buttonVit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });

        final Button buttonStep = (Button) findViewById(R.id.button_steps);
        buttonStep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),StepsCounter.class);
                startActivity(intent);
            }
        });

        final Button buttonStopWatch = (Button) findViewById(R.id.button_stopwatch);
        buttonStopWatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),StopWatch.class);
                startActivity(intent);
            }
        });

        final Button buttonHistogram = (Button) findViewById(R.id.button_histogram);
        buttonHistogram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Histogram.class);
                startActivity(intent);
            }
        });

        final Button buttonTestInsert = (Button) findViewById(R.id.button_testInsert);
        buttonTestInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Context context = getApplicationContext();
                CharSequence text = "Inserting into DB an histogram instance";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                //Date date, double weight, double height, int age, char gender, double waist, double wrist, double forearm

                HistogramObject histogramObj = new HistogramObject(new Date(), 80.0, 150.0, 20, 'M', 23.0, 24.0, 18.0);
                db.insertInHistogram(histogramObj);

            }
        });

        final Button buttonTestGet= (Button) findViewById(R.id.button_testGet);
        buttonTestGet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }



}
