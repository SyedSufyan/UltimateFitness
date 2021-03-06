package com.cs442.uf.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    private static RadioGroup radioGender;
    private static RadioButton radioB;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        Button bSubform = (Button) findViewById(R.id.bSubform);
        bSubform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Radio button stuff
                radioGender = (RadioGroup) findViewById(R.id.rg);
                int choice_id=radioGender.getCheckedRadioButtonId();
                radioB = (RadioButton)findViewById(choice_id);
                String GenderChoice = radioB.getText().toString();
                //store all the data in a variable
                EditText heightField = (EditText) findViewById(R.id.eHeight);
                String heightS = heightField.getText().toString();
                double height = Double.parseDouble(heightS);
                EditText weightField = (EditText) findViewById(R.id.eWeight);
                String weightS = weightField.getText().toString();
                double weight = Double.parseDouble(weightS);
                EditText ageField = (EditText) findViewById(R.id.eAge);
                String ageS = ageField.getText().toString();
                int age =Integer.parseInt(ageS);
                EditText waistField = (EditText) findViewById(R.id.eWaistC);
                String waistS = waistField.getText().toString();
                double waist = Double.parseDouble(waistS);
                EditText wristField = (EditText) findViewById(R.id.eWristC);
                String wristS = wristField.getText().toString();
                double wrist = Double.parseDouble(wristS);
                EditText hipField = (EditText) findViewById(R.id.eHipC);
                String hipS = hipField.getText().toString();
                double hip = Double.parseDouble(hipS);
                EditText forearmField = (EditText) findViewById(R.id.eForearmC);
                String forearmS = forearmField.getText().toString();
                double forearm = Double.parseDouble(forearmS);
                //BMI Calc
                double bmi = (weight/2.20462)/((height/100)*(height/100));

                double bmr = 0;
                double bfp = 0;
                double bodyfatweight;
                double leanbodymass;
                double factor1,factor2,factor3,factor4,factor5;

                if(GenderChoice == "Male")
                {
                    //BMR Calc
                    bmr = 10 * weight + 6.25 * height - 5 * age + 5;
                    //BFP Calc
                    factor1= (weight*1.082)+94.42;
                    factor2= (waist)*4.15;
                    leanbodymass=factor1-factor2;
                    bodyfatweight=weight-leanbodymass;
                    bfp=(bodyfatweight*100)/weight;
                }

                else // Female
                {
                    //BMR Calc
                    bmr = 10 * weight + 6.25 * height - 5 * age - 161;
                    //BFP Calc
                    factor1 = (weight * 0.782) + 8.987;
                    factor2 = (wrist) / 3.140;
                    factor3 = (waist) * 0.157;
                    factor4 = (hip) * 0.249;
                    factor5 = (forearm) * 0.434;
                    leanbodymass = factor1 + factor2 - factor3 - factor4 + factor5;
                    bodyfatweight = weight - leanbodymass;
                    bfp = (bodyfatweight * 100) / weight;
                }


                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                Date dateobj = new Date();

                //make a data object
                HistogramObject obj = new HistogramObject("test",dateobj,weight,height,age,GenderChoice,waist,wrist,hip,forearm,bmi,bmr,bfp);
                //insert the data object to the database
                databaseHelper.insertInHistogram(obj);

                List<HistogramObject> list = new ArrayList<HistogramObject>();

                list = databaseHelper.getAll("test");
                System.out.println("**First value is: " + list.get(0).getRbmi());

                for (HistogramObject auxObj : list)
                {
                    System.out.println("**Value RBMI is: " + auxObj.getRbmi());
                }
                Intent result = new Intent(FormActivity.this,resultActivity.class);
                startActivity(result);

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
