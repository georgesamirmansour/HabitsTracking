package com.example.gorgesamir.habitstracking.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gorge samir on 2017-12-20.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = " habitDB.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEPARATE = " ,";
    private static final String NOT_NULL = " NOT NULL";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE" + HabitContract.HabitEntry.TABLE_NAME
            + " ( " + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA_SEPARATE
            + HabitContract.HabitEntry.COLUMN_NAME + TEXT_TYPE + NOT_NULL + COMMA_SEPARATE
            + HabitContract.HabitEntry.COLUMN_HABIT + TEXT_TYPE + NOT_NULL + COMMA_SEPARATE
            + HabitContract.HabitEntry.COLUMN_GENDER + TEXT_TYPE + NOT_NULL + COMMA_SEPARATE
            + HabitContract.HabitEntry.COLUMN_NUMBER_OF_HABITS + INTEGER_TYPE + NOT_NULL +
            " ); ";


    private static final String SQL_DELETE_ENTRIES = " DROP TABLE IF EXIST " + HabitContract.HabitEntry.TABLE_NAME;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        super.onDowngrade(database, oldVersion, newVersion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
