package com.cs442.uf.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    Button btnAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlarm = (Button)findViewById(R.id.btnAlarm);
    }


    public void onLoginClick(View v)
    {
        if (v.getId() == R.id.btnLogin)
        {
            EditText a = (EditText) findViewById(R.id.etUsername);
            String str = a.getText().toString();

            EditText b = (EditText) findViewById(R.id.etPassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);

            if (pass.equals(password))
            {
                Intent i = new Intent(this, Display.class);
                i.putExtra("username", str);
                startActivity(i);
            }
            else
            {
                Toast.makeText(MainActivity.this, "do not match", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void setAlarm(View view)
    {
            Long alertTime = new GregorianCalendar().getTimeInMillis()+5*1000;

            Intent alertIntent = new Intent(this, AlertReceiver.class);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime, PendingIntent.getBroadcast
                (this, 1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));

            //Toast.makeText(this,"keep an update of application",Toast.LENGTH_SHORT).show();

        }

        public void onSignupClick(View v) {

        if (v.getId() == R.id.btnSignup)
        {
            Intent i = new Intent(this, Signup.class);
            startActivity(i);
        }
    }

    }


