package com.demo.quizmasterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherLogIn extends AppCompatActivity {

    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_log_in);

        btnlogin = findViewById(R.id.btnlogin);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TeacherLogIn.this, TeacherMainMenu.class);
                startActivity(intent);

            }

        });
    }
}