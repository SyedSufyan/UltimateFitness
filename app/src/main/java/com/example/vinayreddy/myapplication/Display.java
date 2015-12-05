package com.example.vinayreddy.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by vinay reddy on 11/23/2015.
 */
public class Display extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String username = getIntent().getStringExtra("username");

        TextView tv = (TextView)findViewById(R.id.eUsername);
        tv.setText(username);
    }

}
