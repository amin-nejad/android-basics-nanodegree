package com.example.android.geographyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View view) {
        EditText usernameEditText = (EditText) findViewById(R.id.name_field);
        String sUsername = usernameEditText.getText().toString();

        RadioButton one_three = (RadioButton) findViewById(R.id.one_three);
        boolean answer_one_three = one_three.isChecked();

        RadioButton two_two = (RadioButton) findViewById(R.id.two_two);
        boolean answer_two_two = two_two.isChecked();

        RadioButton three_one = (RadioButton) findViewById(R.id.three_one);
        boolean answer_three_one = three_one.isChecked();

        CheckBox four_one = (CheckBox) findViewById(R.id.four_one);
        boolean answer_four_one = four_one.isChecked();

        CheckBox four_two = (CheckBox) findViewById(R.id.four_two);
        boolean answer_four_two = four_two.isChecked();

        CheckBox four_three = (CheckBox) findViewById(R.id.four_three);
        boolean answer_four_three = four_three.isChecked();

        CheckBox four_four = (CheckBox) findViewById(R.id.four_four);
        boolean answer_four_four = four_four.isChecked();

        CheckBox four_five = (CheckBox) findViewById(R.id.four_five);
        boolean answer_four_five = four_five.isChecked();

        EditText five = (EditText) findViewById(R.id.five);
        String answer_five = five.getText().toString();

        boolean[] bools = {answer_four_one, answer_four_two,answer_four_three, answer_four_four, answer_four_five};
        int sum = 0;
        for (boolean b : bools) {
            sum += b ? 1 : 0;
        }
        boolean[] bools2 = {answer_four_one, answer_four_two, answer_four_five};
        int sum_new = 0;
        for (boolean b : bools2) {
            sum_new += b ? 1 : 0;
        }
        if (sum==3 && sum_new==3){
            sum=1;
        } else{
            sum=0;
        }
        boolean[] bools3 = {answer_one_three, answer_two_two,answer_three_one};
        int sum2 = 0;
        for (boolean b : bools3) {
            sum2 += b ? 1 : 0;
        }
        int sum3;
        if(Objects.equals(answer_five, "Antarctica")){
            sum3 = sum2 + sum +1;
        }else{
            sum3 = sum2 +sum;
        }
        String statement="";
        if(sum3>2){
            statement = "Congrats "+sUsername+"! You got "+sum3+"/5";
        } else {
            statement = "Poor effort "+sUsername+". You only got "+sum3+"/5";
        }

        if (sUsername.matches("")) {
            Toast.makeText(this, "You did not enter a name.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, statement, Toast.LENGTH_LONG).show();
            return;
        }
    }
}