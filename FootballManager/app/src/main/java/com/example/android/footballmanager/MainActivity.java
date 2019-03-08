package com.example.android.footballmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA =0;
    int ShotsOnTargetTeamA =0;
    int ShotsTeamA =0;
    int scoreTeamB =0;
    int ShotsOnTargetTeamB =0;
    int ShotsTeamB =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    public void GoalForTeamA(View v) {
        scoreTeamA = scoreTeamA +1;
        ShotsOnTargetTeamA=ShotsOnTargetTeamA+1;
        ShotsTeamA=ShotsTeamA+1;
        displayForTeamA(scoreTeamA);
        displayShotsOnTargetForTeamA(ShotsOnTargetTeamA);
        displayShotsForTeamA(ShotsTeamA);
    }
    public void ShotOnTargetForTeamA(View v) {
        ShotsOnTargetTeamA=ShotsOnTargetTeamA+1;
        ShotsTeamA=ShotsTeamA+1;
        displayShotsOnTargetForTeamA(ShotsOnTargetTeamA);
        displayShotsForTeamA(ShotsTeamA);
    }
    public void ShotForTeamA(View v) {
        ShotsTeamA=ShotsTeamA+1;
        displayShotsForTeamA(ShotsTeamA);
    }
    /**
     * Displays the given scores for Team B.
     */
    public void GoalForTeamB(View v) {
        scoreTeamB = scoreTeamB +1;
        ShotsOnTargetTeamB=ShotsOnTargetTeamB+1;
        ShotsTeamB=ShotsTeamB+1;
        displayForTeamB(scoreTeamB);
        displayShotsOnTargetForTeamB(ShotsOnTargetTeamB);
        displayShotsForTeamB(ShotsTeamB);
    }
    public void ShotOnTargetForTeamB(View v) {
        ShotsOnTargetTeamB=ShotsOnTargetTeamB+1;
        ShotsTeamB=ShotsTeamB+1;
        displayShotsOnTargetForTeamB(ShotsOnTargetTeamB);
        displayShotsForTeamB(ShotsTeamB);
    }
    public void ShotForTeamB(View v) {
        ShotsTeamB=ShotsTeamB+1;
        displayShotsForTeamB(ShotsTeamB);
    }
    /**
     * Resets scores for both teams.
     */
    public void Reset(View v) {
        scoreTeamA=0;
        ShotsOnTargetTeamA=0;
        ShotsTeamA=0;
        scoreTeamB=0;
        ShotsOnTargetTeamB=0;
        ShotsTeamB=0;
        displayForTeamA(scoreTeamA);
        displayShotsOnTargetForTeamA(ShotsOnTargetTeamA);
        displayShotsForTeamA(ShotsTeamA);
        displayForTeamB(scoreTeamB);
        displayShotsOnTargetForTeamB(ShotsOnTargetTeamB);
        displayShotsForTeamB(ShotsTeamB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayShotsOnTargetForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_shots_on_target);
        scoreView.setText(String.valueOf(score));
    }
    public void displayShotsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_shots);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayShotsOnTargetForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_shots_on_target);
        scoreView.setText(String.valueOf(score));
    }
    public void displayShotsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_shots);
        scoreView.setText(String.valueOf(score));
    }
}
