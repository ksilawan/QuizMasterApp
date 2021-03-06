package com.demo.quizmasterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputGrades extends AppCompatActivity {

        Button computebtn;
        EditText engageInput;
        EditText explainInput;
        EditText elabInput;
        EditText exploreInput;
        EditText evaluateInput;
        TextView finalGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_grades);

        computebtn = (Button) findViewById(R.id.computebtn);
        engageInput = (EditText) findViewById(R.id.engageInput);
        explainInput = (EditText) findViewById(R.id.explainInput);
        elabInput = (EditText) findViewById(R.id.elabInput);
        exploreInput = (EditText) findViewById(R.id.exploreInput);
        evaluateInput = (EditText) findViewById(R.id.evaluateInput);


        computebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String engage = engageInput.getText().toString();
                String explain = explainInput.getText().toString();
                String elab = elabInput.getText().toString();
                String explore = exploreInput.getText().toString();
                String eval = evaluateInput.getText().toString();

                Intent intent = new Intent(InputGrades.this, DisplayGrades.class);
                intent.putExtra("Engage", engage);
                intent.putExtra("Explain", explain);
                intent.putExtra("Elab", elab);
                intent.putExtra("Explore", explore);
                intent.putExtra("Eval", eval);
                startActivity(intent);

            }
        });
    }
}