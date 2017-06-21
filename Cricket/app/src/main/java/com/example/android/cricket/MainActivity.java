package com.example.android.cricket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the cricket score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {


    private static final android.R.attr R = ;
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int out1 = 0;
    int out2 = 0;
    int flag = 0;
    String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void addFourForTeamA(View v) {
        scoreTeamA = scoreTeamA + 4;
        displayForTeamA(scoreTeamA);
    }

    public void addSixForTeamA(View v) {
        scoreTeamA = scoreTeamA + 6;
        displayForTeamA(scoreTeamA);
    }

    public void outForTeamA(View v) {
        out1 = out1 + 1;
        displayOutForTeamA("Out:" + out1);
    }

    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addFourForTeamB(View v) {
        scoreTeamB = scoreTeamB + 4;
        displayForTeamB(scoreTeamB);
    }

    public void addSixForTeamB(View v) {
        scoreTeamB = scoreTeamB + 6;
        displayForTeamB(scoreTeamB);
    }

    public void outForTeamB(View v) {

        out2 = out2 + 1;
        displayOutForTeamB("Out:" + out2);
    }

    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        out1 = 0;
        out2 = 0;
        winner = " ";
        displayOutForTeamA("Out:" + out1);
        displayOutForTeamB("Out:" + out2);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFinalScore(winner);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void finalScore(View v) {
        if (scoreTeamA > scoreTeamB) flag = 1;
        else if (scoreTeamA == scoreTeamB) flag = 2;
        else flag = 0;
        if (flag == 1) winner = "Team_A_is_winner";
        if (flag == 0) winner = "Team_B_is_winner";
        if (flag == 2) winner = "Match_tied";
        displayFinalScore(winner);
    }

    public void displayOutForTeamA(String out) {
        TextView flagView = (TextView) findViewById(R.id.team_a_out);
        flagView.setText(String.valueOf(out));
    }

    public void displayOutForTeamB(String out) {
        TextView flagView = (TextView) findViewById(R.id.team_b_out);
        flagView.setText(String.valueOf(out));
    }

    public void displayFinalScore(String winner) {
        TextView flagView = (TextView) findViewById(R.id.final_score);
        flagView.setText(String.valueOf(winner));
    }

}
