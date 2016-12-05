package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by diegog on 12/2/2016.
 */

public class HabitContract  {
    private HabitContract(){}

    public static final String CONTENT_AUTHORITY = "com.example.android.habittracker";

    public static final class ActivityEntry implements BaseColumns{
        public static final String TABLE_NAME = "activity";

        public static final String _ID = BaseColumns._ID;


        public static final String COLUMN_ACTIVITY_TYPE = "type";

        public static final String COLUMN_ACTIVITY_DATE = "date";

        public static final String COLUMN_ACTIVITY_DISTANCE = "distance";

        public static final String COLUMN_ACTIVITY_DURATION = "duration";





    }

}
