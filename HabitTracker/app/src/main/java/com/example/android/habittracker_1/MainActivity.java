package com.example.android.habittracker_1;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.habittracker_1.HabitContract.HabitEntry;

public class MainActivity extends AppCompatActivity {
    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);
        mDbHelper = new HabitDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }
private Cursor readMethod(){
    SQLiteDatabase db = mDbHelper.getReadableDatabase();
    String[] projection = {
            HabitEntry._ID,
            HabitEntry.COLUMN_PERSON_NAME,
            HabitEntry.COLUMN_PERSON_HOURS,
            HabitEntry.COLUMN_PERSON_HABIT,
            HabitEntry.COLUMN_PERSON_HOURS,};

    Cursor cursor = db.query(
            HabitEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null);
    return cursor;

}
    private void displayDatabaseInfo() {


        Cursor read = readMethod();

        TextView displayView = (TextView) findViewById(R.id.text_view_habit);

        try {

            displayView.setText("The habit table contains " + read.getCount() + " habits.\n\n");
            displayView.append(HabitEntry._ID + " - " +
                    HabitEntry.COLUMN_PERSON_NAME + " - " +
                    HabitEntry.COLUMN_PERSON_HOURS + " - " +
                    HabitEntry.COLUMN_PERSON_HABIT + "\n");

            int idColumnIndex = read.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = read.getColumnIndex(HabitEntry.COLUMN_PERSON_NAME);
            int hoursColumnIndex = read.getColumnIndex(HabitEntry.COLUMN_PERSON_HOURS);
            int habitColumnIndex = read.getColumnIndex(HabitEntry.COLUMN_PERSON_HABIT);

            while (read.moveToNext()) {

                int currentID = read.getInt(idColumnIndex);
                String currentName = read.getString(nameColumnIndex);
                String currentHours = read.getString(hoursColumnIndex);
                String currentHabit = read.getString(habitColumnIndex);

                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentHours + " - " +
                        currentHabit));
            }
        } finally {
            read.close();
        }
    }


    private void insertPet() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_PERSON_NAME, "Rahul");
        values.put(HabitEntry.COLUMN_PERSON_HOURS, "5");
        values.put(HabitEntry.COLUMN_PERSON_HABIT, "Sleeping");

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {

            Toast.makeText(this, "Error with saving Habit", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_insert_dummy_data:
                insertPet();
                displayDatabaseInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_habit, menu);
        return true;
    }
}
