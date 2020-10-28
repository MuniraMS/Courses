package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import java.util.ArrayList;
import android.content.Context;



public class showstudentinfo extends AppCompatActivity {
    controllerdb controllerdb = new controllerdb (this);
    SQLiteDatabase db;
    private ArrayList <String> ID = new ArrayList<String>();
    private ArrayList <String> name = new ArrayList<String>();
    private ArrayList <String> StuID = new ArrayList<String>();
    private ArrayList <String> Grade = new ArrayList<String>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showstudentinfo);
        lv = (ListView) findViewById(R.id.lstview);
    }
    @Override
    protected void onResume() {
        displayData();
        super.onResume();
    }
    private void displayData() {
        db = controllerdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM studentInfo",null);
        ID.clear();
        name.clear();
        StuID.clear();
        Grade.clear();
        if( cursor.moveToFirst() ){
            do {
                ID.add(cursor.getString(cursor.getColumnIndex("ID")));
                name.add(cursor.getString(cursor.getColumnIndex("Name")));
                StuID.add(cursor.getString(cursor.getColumnIndex("StuID")));
                Grade.add(cursor.getString(cursor.getColumnIndex("Grade")));
            } while (cursor.moveToNext());
        }

        CustomAdapter ca = new CustomAdapter(showstudentinfo.this,ID,name,StuID,Grade);
        lv.setAdapter(ca);
        cursor.close();

    }
}
