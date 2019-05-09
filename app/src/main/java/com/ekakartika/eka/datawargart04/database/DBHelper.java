package com.ekakartika.eka.datawargart04.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "datawarga.db";
    public static final int DB_VERSI = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSI);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableDataWarga.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableDataWarga.NAME);
        onCreate(db);
    }
}
