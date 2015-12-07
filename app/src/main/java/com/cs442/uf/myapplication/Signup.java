package com.cs442.uf.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vinay reddy on 11/23/2015.
 */
public class Signup extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onRegisterClick(View v)
    {
        if(v.getId()==R.id.btnRegister)
        {
            EditText name = (EditText)findViewById(R.id.etName);
            EditText email = (EditText)findViewById(R.id.etEmail);
            EditText uname = (EditText)findViewById(R.id.etUsername);
            EditText pass = (EditText)findViewById(R.id.etPasswordR);
            EditText cpass = (EditText)findViewById(R.id.etCpasswordR);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String passstr = pass.getText().toString();
            String cpassstr = cpass.getText().toString();

            if(!passstr.equals(cpassstr))
            {
                Toast.makeText(this,"password do not match",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(passstr);

                helper.insertContact(c);
            }

        }

        Toast.makeText(this,"successful",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

}
