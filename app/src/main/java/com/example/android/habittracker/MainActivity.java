package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.habittracker.data.ActivityDbHelper;
import com.example.android.habittracker.data.HabitContract.ActivityEntry;

public class MainActivity extends AppCompatActivity {

    ActivityDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new ActivityDbHelper(this);

        insertActivity();


    }

    private void insertActivity (){
        mDbHelper = new ActivityDbHelper(this);
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ActivityEntry.COLUMN_ACTIVITY_TYPE, "Running");
        values.put(ActivityEntry.COLUMN_ACTIVITY_DATE, "12/01/16");
        values.put(ActivityEntry.COLUMN_ACTIVITY_DISTANCE,"3.5");
        values.put(ActivityEntry.COLUMN_ACTIVITY_DURATION, "35");

        long newRowId = database.insert(ActivityEntry.TABLE_NAME, null,values);
        Log.v("Main_Activity", "New row inserted: "+ newRowId);
    }

    private void displayActivity(){
        mDbHelper = new ActivityDbHelper(this);

        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        String[] projection = {
                ActivityEntry._ID,
                ActivityEntry.COLUMN_ACTIVITY_TYPE,
                ActivityEntry.COLUMN_ACTIVITY_DATE,
                ActivityEntry.COLUMN_ACTIVITY_DISTANCE,
                ActivityEntry.COLUMN_ACTIVITY_DURATION
        };

        Cursor cursor = database.query(
                ActivityEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        

    }
}
