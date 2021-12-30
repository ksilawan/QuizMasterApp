package com.demo.quizmasterapp;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayGrades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_grades);

        TextView finalGrade = (TextView) findViewById(R.id.finalGrade);

        String engageText = getIntent().getStringExtra("Engage");
        float engage = Float.parseFloat(engageText);
        float engageFinal = engage - (engage * 0.10f);

        String explainText = getIntent().getStringExtra("Explain");
        float explain = Float.parseFloat(explainText);
        float explainFinal = explain - (explain * 0.10f);

        String elabText = getIntent().getStringExtra("Elab");
        float elab = Float.parseFloat(elabText);
        float elabFinal = elab - (elab * 0.20f);

        String exploreText = getIntent().getStringExtra("Explore");
        float explore = Float.parseFloat(exploreText);
        float exploreFinal = explore - (explore * 0.40f);

        String evalText = getIntent().getStringExtra("Eval");
        float eval = Float.parseFloat(evalText);
        float evalFinal = eval - (eval * 0.20f);

        float grade = engageFinal+explainFinal+elabFinal+exploreFinal+evalFinal;
        //float grade = 69;

        String finalFinalGrade = "FINAL GRADE: " + grade;

        finalGrade.setText(finalFinalGrade);


    }
}