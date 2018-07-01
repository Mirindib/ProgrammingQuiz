package com.nam.android.programmingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// display the user results on submit answer clicked
    public void showAnswer(View view) {
        String[] answers = evaluateGui();

        int result = evaluateQuiz(answers);

        toastResult(result);
    }

    public int evaluateQuiz(String[] answers) {
        int result = 0;
        String[] correctAnswers = {"Java has a huge developper community", "String", "as many as you want", "Three", "extends", "All are correct", "False"};

        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers[i].equals(correctAnswers[i])) {
                result++;
            }
        }

        return result;
    }


    public String[] evaluateGui() {
        String[] hydro = new String[7];


        hydro[0] = evaluateRadioGroup(R.id.question1).toLowerCase();
        hydro[1] = evaluateRadioGroup(R.id.question2).toLowerCase();
        hydro[2] = evaluateRadioGroup(R.id.question3).toLowerCase();
        hydro[3] = evaluateRadioGroup(R.id.question4).toLowerCase();
        hydro[4] = evaluateRadioGroup(R.id.question5).toLowerCase();
        hydro[5] = evaluateRadioGroup(R.id.question6).toLowerCase();
        hydro[6] = evaluateRadioGroup(R.id.question7).toLowerCase();


        return hydro;
    }

// Toast message display

    public void toastResult(int result) {
        String message = " You have got " + result + "question right " + " out of 7. ";

        if (result == 0) {
            message += "Please choose a correct answer";
        } else if (result == 1) {
            message += "Please Try again ";
        } else if (result == 2) {
            message += "You are almost there!!Retake the quiz.";
        } else if (result == 3) {
            message += "Nice! Keep going.";
        } else if (result == 4) {
            message += "Very nice!";
        } else if (result == 5) {
            message += "Absolutely awesome!";
        } else if (result == 6) {
            message += "Congratulation you got it!";
        } else if (result == 7) {
            message += "Waou!!! almost there!";
        } else if (result == 8) {
            message += "Absolutely perfect you made it!";
        }

        Toast reportResult = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT);
        reportResult.show();
    }

    private String evaluateRadioGroup(int id) {
        RadioGroup radioGroupQuestion;
        RadioButton radioButtonQuestion;

        radioGroupQuestion = findViewById(id);

        int radioButtonId = radioGroupQuestion.getCheckedRadioButtonId();
        radioButtonQuestion = findViewById(radioButtonId);

        if (radioButtonQuestion == null) {
            return "";
        }

        return (String) radioButtonQuestion.getText();
    }


    //Reser the Radio buttons
    public void reset(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question1);
        radioGroup.clearCheck();
        //Reset question 2
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.question2);
        radioGroup2.clearCheck();
        //Reset question 2
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.question3);
        radioGroup3.clearCheck();


        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.question4);
        radioGroup4.clearCheck();


        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.question5);
        radioGroup5.clearCheck();


        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.question6);
        radioGroup6.clearCheck();


        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.question7);
        radioGroup7.clearCheck();
    }

}
