package com.example.login_page.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_page.R;
import com.example.login_page.database.MyDatabase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    TextView login;
    Button createuser;
    TextInputEditText pass, conpass, user, email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);


        login = findViewById(R.id.login);
        createuser = findViewById(R.id.createuser);
        pass = findViewById(R.id.pass);
        conpass = findViewById(R.id.conpass);
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);


        MyDatabase db = new MyDatabase(Signup.this);


        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Boolean d = db.insertdata(user.getText().toString(), email.getText().toString(), pass.getText().toString());

                if(d == true)
                {
                    startActivity(new Intent(Signup.this, SignIn.class));
                    finish();
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Signup.this, SignIn.class));
                finish();
            }
        });

    }
}