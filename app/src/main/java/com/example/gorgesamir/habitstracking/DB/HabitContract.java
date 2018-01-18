package com.example.gorgesamir.habitstracking.DB;

import android.provider.BaseColumns;

/**
 * Created by gorge samir on 2017-12-20.
 */

public final class HabitContract {

    public static abstract class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = " habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = " name";
        public static final String COLUMN_HABIT = " habit";
        public static final String COLUMN_GENDER = " gender";
        public static final String COLUMN_NUMBER_OF_HABITS = " NumberOfHabits";

    }
}
