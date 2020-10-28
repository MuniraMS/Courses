package com.example.assignmenttwo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class controllerdb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="SqliteListviewDB";
    public controllerdb (Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query ="CREATE TABLE IF NOT EXISTS studentInfo(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR, StuID VARCHAR, Grade VARCHAR);";
        db.execSQL(query);

    }
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query="DROP TABLE IF EXISTS studentInfo";
        db.execSQL(query);
        onCreate(db);
    }
}
