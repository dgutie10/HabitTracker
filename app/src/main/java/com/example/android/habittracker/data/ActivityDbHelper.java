package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.habittracker.data.HabitContract.ActivityEntry;

/**
 * Created by diegog on 12/5/2016.
 */

public class ActivityDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "habitTracker.db";
    public static final int DATABASE_VERSION = 1;
    private static final String LOG_TAG = ActivityDbHelper.class.getSimpleName();


    public ActivityDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE "+ ActivityEntry.TABLE_NAME + " ("
                + ActivityEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ActivityEntry.COLUMN_ACTIVITY_TYPE + " TEXT NOT NULL, "
                + ActivityEntry.COLUMN_ACTIVITY_DATE + " TEXT NOT NULL, "
                + ActivityEntry.COLUMN_ACTIVITY_DISTANCE + " REAL NOT NULL DEFAULT 0, "
                + ActivityEntry.COLUMN_ACTIVITY_DURATION + " TEXT NOT NULL);";

        Log.e(LOG_TAG, "SQL Statement: "+ SQL_CREATE_TABLE);

        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
