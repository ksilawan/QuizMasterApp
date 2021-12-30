package com.demo.quizmasterapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizPage extends AppCompatActivity {

    private TextView questiontxt, scoretxt, questionNo, timer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;
    private Button btnNext;

    private Timer quizTimer;
    private int seconds = 0;


    int totalQuestions;
    int qnCounter = 0;
    int score = 0;

    ColorStateList dfRbColor;
    boolean answered;

    //CountDownTimer countDownTimer;

    private QuestionModel currentQuestion;



    private List<QuestionModel> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizpage);

        questionsList = new ArrayList<>();
        questiontxt = findViewById(R.id.questiontxt);
        timer = findViewById(R.id.timer);
        scoretxt = findViewById(R.id.scoretxt);
        questionNo = findViewById(R.id.questionNo);


        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btnNext = findViewById(R.id.btnNext);

        dfRbColor = rb1.getTextColors();

        startTimer(timer);
        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();





        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered == false){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                        checkAnswer();
                        //countDownTimer.cancel();

                    }else{
                        Toast.makeText(QuizPage.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });

    }


    private void startTimer(TextView timerTextView){

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(seconds == 0){
                    seconds = 20;
                }
                else if(seconds == 0){

                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizPage.this, "Time Over!!!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizPage.this, QuizOverPage.class);
                    startActivity(intent);

                    finish();
                }
                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalSeconds = String.valueOf(seconds);

                        if(finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds;
                        }

                        timerTextView.setText("00:" + finalSeconds);
                    }
                });
            }

        }, 1000, 1000);
    }


    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
        if(answerNo == currentQuestion.getCorrectAnsNo()){
            score++;
            scoretxt.setText("Score: " + score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;

            case 2:
                rb2.setTextColor(Color.GREEN);
                break;

            case 3:
                rb3.setTextColor(Color.GREEN);
                break;

        }
        if(qnCounter < totalQuestions){
            btnNext.setText("Submit");
        }
        else{
            btnNext.setText("Finish");
        }
    }



    private void showNextQuestion(){

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);


        if(qnCounter < totalQuestions){
            //timerCount();
            currentQuestion = questionsList.get(qnCounter);
            questiontxt.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getAns1());
            rb2.setText(currentQuestion.getAns2());
            rb3.setText(currentQuestion.getAns3());

            qnCounter++;
            btnNext.setText(("Next"));
            questionNo.setText("Question: " + qnCounter + "/" + totalQuestions);
            answered = false;
        }
        else{

            Intent intent = new Intent(QuizPage.this, QuizOverPage.class);
            startActivity(intent);


            finish();
        }

    }

    /* private void timerCount() {

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText("00:" + 1/1000);
            }

            @Override
            public void onFinish() {
                showNextQuestion();
            }
        }.start();
    }

*/

    private void addQuestions(){
        questionsList.add(new QuestionModel("1. What is splash screen in android?", "A - Initial activity of an application",
                                            "B - Initial service of an application", "C - Initial method of an application", 1 ));

        questionsList.add(new QuestionModel("2. What is broadcast receiver in android? ", "A - It will react on broadcast announcements.",
                                            "B - It will do background functionalities as services.", "C - It will pass the data between activities.", 1 ));

        questionsList.add(new QuestionModel("3. What is an anonymous class in android?", "Interface class",
                                            "B - A class that does not have a name but have functionalities in it", "C - Java class", 2 ));

        questionsList.add(new QuestionModel("4.  What is the package name of JSON?", "A - com.json",
                                            "B - in.json", "C - org.json", 3 ));

        questionsList.add(new QuestionModel("5. What is the purpose of super.onCreate() in android?", "A - To create an activity",
                "B - To create a graphical window for subclass", "C - It allows the developers to write the program", 2 ));


    }
}