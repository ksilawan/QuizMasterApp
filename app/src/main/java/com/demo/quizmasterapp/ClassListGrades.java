package com.demo.quizmasterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ClassListGrades extends AppCompatActivity {

    Button btnupdate1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list_grades);

        btnupdate1 = (Button) findViewById(R.id.btnupdate1);

        btnupdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ClassListGrades.this, InputGrades.class);
                startActivity(intent);

            }
        });

    }
}