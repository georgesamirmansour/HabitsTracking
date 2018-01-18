package com.example.gorgesamir.habitstracking;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gorgesamir.habitstracking.DB.HabitContract;
import com.example.gorgesamir.habitstracking.DB.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    HabitDbHelper habitDbHelper = new HabitDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertIntoHabits();
        displayDataFromHabits();
    }


    private void insertIntoHabits() {
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        SQLiteDatabase database = habitDbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(HabitContract.HabitEntry.COLUMN_NAME, "george");
        contentValues.put(HabitContract.HabitEntry.COLUMN_HABIT, "reading");
        contentValues.put(HabitContract.HabitEntry.COLUMN_GENDER, "male");
        contentValues.put(HabitContract.HabitEntry.COLUMN_NUMBER_OF_HABITS, 1);

        database.insert(HabitContract.HabitEntry.TABLE_NAME, null, contentValues);
    }


    public void displayDataFromHabits() {
        SQLiteDatabase database = habitDbHelper.getReadableDatabase();
        String finalData = null;
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT,
                HabitContract.HabitEntry.COLUMN_GENDER,
        };
        Cursor cursor = database.query(
                HabitContract.HabitEntry.TABLE_NAME
                , projection
                , null
                , null
                , null
                , null
                , null
        );
        try {


            int idColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_NAME);
            int habitColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT);
            int genderColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_GENDER);

            while (cursor.moveToNext()) {

                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentHabit = cursor.getString(habitColumnIndex);
                int currentGender = cursor.getInt(genderColumnIndex);
                finalData = currentID + currentName + currentHabit + currentGender + "\n";
            }
        } finally {
            cursor.close();
        }
    }
}
