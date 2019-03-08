package com.example.aanej.tracker;

import android.provider.BaseColumns;

public class Contract {

    public Contract() {}

    public class FoodEntry implements BaseColumns {

        public final static String TABLE_NAME = "Food_Diary";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DATE = "Date";
        public final static String COLUMN_TIME = "Time";
        public final static String COLUMN_FOOD = "Food";
        public final static String COLUMN_CALORIES = "Calories";
        public final static String COLUMN_COMMENT = "Comment";
    }
}