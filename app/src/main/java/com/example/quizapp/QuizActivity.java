package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {
    private Button submitButton;
    private int score;
    private RadioGroup numOneRadioGroup;
    private RadioGroup numTwoRadioGroup;
    private RadioGroup numThreeRadioGroup;
    private RadioGroup numSixRadioGroup;

    private EditText editText;
    private CheckBox gangaCheckBox;
    private CheckBox kuntiCheckBox;
    private CheckBox radhaCheckBox;
    private CheckBox satyavatiCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        gangaCheckBox = findViewById(R.id.ganga_checkbox);
        radhaCheckBox = findViewById(R.id.radha_checkbox);
        satyavatiCheckBox = findViewById(R.id.satyavati_checkbox);
        kuntiCheckBox = findViewById(R.id.kunti_checkbox);
        numOneRadioGroup = findViewById(R.id.numOneRadioGroup);
        numTwoRadioGroup =findViewById(R.id.numTwoRadioGroup);
        numThreeRadioGroup = findViewById(R.id.numThreeRadioGroup);
        numSixRadioGroup = findViewById(R.id.numSixRadioGroup);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;

                if(numOneRadioGroup.getCheckedRadioButtonId() == R.id.oneOne_radio){
                    score += 1;
                }
                if(numTwoRadioGroup.getCheckedRadioButtonId() == R.id.twoThree_radio){
                    score += 1;
                }
                if(numThreeRadioGroup.getCheckedRadioButtonId() == R.id.numThreeRadioGroup){
                    score += 1;
                }

                if(numSixRadioGroup.getCheckedRadioButtonId() == R.id.SixOne_radio){
                    score += 1;
                }

                String useranswer = editText.getText().toString();
                if(useranswer.equalsIgnoreCase("18")){
                    score += 1;
                }
                if(gangaCheckBox.isChecked() && satyavatiCheckBox.isChecked() && !radhaCheckBox.isChecked()
                        && !kuntiCheckBox.isChecked()){
                    score += 1;
                }

                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("SCORE", score+"/5");
                startActivity(intent);
            }
        });
    }
}
