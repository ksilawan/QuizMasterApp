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


        btnstudent = (Button) findViewById(R.id.btnstart);
        btnteacher = (Button) findViewById(R.id.btnteacher);


        btnstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(OptionPage.this, studentLogIn.class);
                startActivity(intent);

            }
        });

    }
}