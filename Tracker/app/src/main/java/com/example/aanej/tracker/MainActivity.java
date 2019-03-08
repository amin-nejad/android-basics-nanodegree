package com.example.aanej.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DbHelper habitDbHelper = new DbHelper(this);
        Date date = new Date();
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatter_time = new SimpleDateFormat("hhmm");
        String dateString = formatter.format(date);
        String timeString = formatter_time.format(time);
        int dateInt = Integer.parseInt(dateString);
        int timeInt = Integer.parseInt(timeString);

        habitDbHelper.insertFood(dateInt, timeInt, "Pasta", 123, "Yummy");
        habitDbHelper.insertFood(dateInt, timeInt, "Steak", 456, "Mmmmm");

        Cursor cursor = habitDbHelper.readMeals();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) + " " + cursor.getString(3));
        }
    }
}
