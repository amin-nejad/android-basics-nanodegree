package com.example.aanej.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "food_database.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_TRACKING_DIARY = "CREATE TABLE " + Contract.FoodEntry.TABLE_NAME +
                "(" + Contract.FoodEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Contract.FoodEntry.COLUMN_DATE + " INTEGER NOT NULL," +
                Contract.FoodEntry.COLUMN_TIME + " INTEGER NOT NULL," +
                Contract.FoodEntry.COLUMN_FOOD + " TEXT NOT NULL," +
                Contract.FoodEntry.COLUMN_CALORIES + " INTEGER," +
                Contract.FoodEntry.COLUMN_COMMENT + " TEXT);";

        Log.v("DbHelper", "create table: " + CREATE_TABLE_TRACKING_DIARY);
        sqLiteDatabase.execSQL(CREATE_TABLE_TRACKING_DIARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {

    }

    public void insertFood(int date, int time, String food, int calories, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.FoodEntry.COLUMN_DATE, date);
        values.put(Contract.FoodEntry.COLUMN_TIME, time);
        values.put(Contract.FoodEntry.COLUMN_FOOD, food);
        values.put(Contract.FoodEntry.COLUMN_CALORIES, calories);
        values.put(Contract.FoodEntry.COLUMN_COMMENT, comment);
        db.insert(Contract.FoodEntry.TABLE_NAME, null, values);
    }

    public Cursor readMeals() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Contract.FoodEntry._ID,
                Contract.FoodEntry.COLUMN_DATE,
                Contract.FoodEntry.COLUMN_TIME,
                Contract.FoodEntry.COLUMN_FOOD,
                Contract.FoodEntry.COLUMN_CALORIES,
                Contract.FoodEntry.COLUMN_COMMENT
        };
        Cursor cursor = db.query(
                Contract.FoodEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}
