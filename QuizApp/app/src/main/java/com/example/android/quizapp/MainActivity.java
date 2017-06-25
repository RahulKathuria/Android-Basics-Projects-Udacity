package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t, t2;
    RadioButton r, r29;
    CheckBox c1, c2, c3, c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (EditText) findViewById(R.id.album_description_view);
        r = (RadioButton) findViewById(R.id.nd_RadioButton);
        c1 = (CheckBox) findViewById(R.id.ch1_checkbox);
        c2 = (CheckBox) findViewById(R.id.ch2_checkbox);
        c3 = (CheckBox) findViewById(R.id.ch3_checkbox);
        c4 = (CheckBox) findViewById(R.id.ch4_checkbox);
        t2 = (EditText) findViewById(R.id.q5_enterText);
        r29 = (RadioButton) findViewById(R.id.radio_button_29);
    }


    public void submit(View v) {
        int score = 0;
        String s = t2.getText().toString();

        String str = t.getText().toString();
        if (r29.isChecked())
            score += 1;
        if (s.equalsIgnoreCase("rajasthan"))
            score += 1;
        if (str.equalsIgnoreCase("narendra modi"))
        score += 1;
        if (r.isChecked())
            score += 1;
        if (c1.isChecked() && c2.isChecked() && c3.isChecked() && !c4.isChecked())
            score += 1;
        if(score==5)Toast.makeText(this, "You scored full marks" , Toast.LENGTH_LONG).show();
        else
       Toast.makeText(this, "total score is =" + score, Toast.LENGTH_LONG).show();


    }
}