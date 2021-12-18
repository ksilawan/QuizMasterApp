package com.demo.quizmasterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayGrades extends AppCompatActivity {

    TextView finalGrade;
    EditText engageInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_grades);

        finalGrade = (TextView) findViewById(R.id.finalGrade);

        float engage = Float.parseFloat(engageInput.getText().toString());
        float engageFinal = engage - (engage * 0.10f);

        finalGrade.setText("FINAL GRADE: " + engageFinal);


    }
}