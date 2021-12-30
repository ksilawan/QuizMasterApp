package com.demo.quizmasterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherMainMenu extends AppCompatActivity {

    Button btnattendance;
    Button btninputgrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_menu);

        btninputgrades = (Button) findViewById(R.id.btninputgrades);
        btnattendance = (Button) findViewById(R.id.btnattendance);


        btninputgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TeacherMainMenu.this, ClassListGrades.class);
                startActivity(intent);

            }
        });

    }
}