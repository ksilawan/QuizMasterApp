package com.demo.quizmasterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentMenu extends AppCompatActivity {

    Button quizbtn, gradesbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);


        quizbtn = (Button) findViewById(R.id.quizbtn);
        gradesbtn = (Button) findViewById(R.id.gradesbtn);

        quizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StudentMenu.this, QuizPage.class);
                startActivity(intent);

            }
        });

    }
}