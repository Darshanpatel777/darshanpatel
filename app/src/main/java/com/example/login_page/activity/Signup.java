package com.example.login_page.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_page.R;
import com.example.login_page.database.MyDatabase;

public class Signup extends AppCompatActivity {
    TextView login;
Button createuser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        login = findViewById(R.id.login);
        createuser = findViewById(R.id.createuser);

        MyDatabase db = new MyDatabase(Signup.this);

        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.insertdata("nency1","nency@gmail.com","nency@123");

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