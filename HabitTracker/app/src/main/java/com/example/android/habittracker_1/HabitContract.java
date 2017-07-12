package com.example.android.habittracker_1;

import android.provider.BaseColumns;

/**
 * Created by Rk on 10-01-2017.
 */
public class HabitContract {
    private HabitContract() {

    }

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "Habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PERSON_NAME = "name";
        public final static String COLUMN_PERSON_HABIT = "habit";
        public final static String COLUMN_PERSON_HOURS = "hours";
    }

}
