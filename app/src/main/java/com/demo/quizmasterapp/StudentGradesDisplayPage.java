package com.demo.quizmasterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentGradesDisplayPage extends AppCompatActivity {

    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grades_display_page);

        btnback = findViewById(R.id.btnback);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StudentGradesDisplayPage.this, StudentMainMenu.class);
                startActivity(intent);


            }


        });

    }
}