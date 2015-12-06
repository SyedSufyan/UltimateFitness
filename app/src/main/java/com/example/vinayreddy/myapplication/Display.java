package com.example.vinayreddy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by vinay reddy on 11/23/2015.
 */

public class Display extends Activity {

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
                Intent intent = new Intent(v.getContext(),Stopwatch.class);
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
    }



}
