package com.demo.quizmasterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionPage extends AppCompatActivity {

    Button btnstudent;
    Button btnteacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_page);

        btnstudent = findViewById(R.id.btnstudent);
        btnteacher = findViewById(R.id.btnteacher);



        btnstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OptionPage.this, StudentLogIn.class);
                startActivity(intent);

            }

        });


        btnteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OptionPage.this, TeacherLogIn.class);
                startActivity(intent);

            }

        });

    }
}