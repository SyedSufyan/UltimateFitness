package com.cs442.uf.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button bSubform = (Button) findViewById(R.id.bSubform);
        bSubform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //store all the data in a variable
                EditText heightField = (EditText) findViewById(R.id.eHeight);
                String heightS = heightField.getText().toString();
                int height = Integer.parseInt(heightS);
                EditText weightField = (EditText) findViewById(R.id.eWeight);
                String weightS = weightField.getText().toString();
                int weight = Integer.parseInt(weightS);
                EditText ageField = (EditText) findViewById(R.id.eAge);
                String ageS = heightField.getText().toString();
                int age = Integer.parseInt(ageS);
                EditText waistField = (EditText) findViewById(R.id.eWaistC);
                String waistS = heightField.getText().toString();
                int waist = Integer.parseInt(waistS);
                EditText wristField = (EditText) findViewById(R.id.eWristC);
                String wristS = heightField.getText().toString();
                int wrist = Integer.parseInt(wristS);
                EditText hipField = (EditText) findViewById(R.id.eHipC);
                String hipS = heightField.getText().toString();
                int hip = Integer.parseInt(hipS);
                EditText forearmField = (EditText) findViewById(R.id.eForearmC);
                String forearmS = heightField.getText().toString();
                int forearm = Integer.parseInt(forearmS);

            }
            });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
