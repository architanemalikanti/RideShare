package com.example.rideShare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RideShare.db";

    private static final String CREATE_STUDENT_TABLE = "CREATE TABLE \"student\" (\n" +
            "\t\"id\"\tINTEGER,\n" +
            "\t\"firstname\"\tTEXT,\n" +
            "\t\"email\"\tTEXT,\n" +
            "\t\"password\"\tTEXT,\n" +
            "\t\"lastname\"\tTEXT,\n" +
            "\t\"ridecommitedday\"\tTEXT,\n" +
            "\tPRIMARY KEY(\"id\")\n" +
            ")"; //primary identifier of the student is the student's lunch code. usually the database assigns it own number but i changed that.

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + "student";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//         This database is only a cache for online data, so its upgrade policy is
//         to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void insert(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        long newRowId = db.insert("student", null, values);
    }

    public void insert(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void update(String tableName, ContentValues values, String whereClause) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(tableName, values, whereClause, null);
    }

    public boolean loginQuery(String tableName, String[] tableColumns, String whereClause, String[] whereArgs, String orderBy, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(tableName, tableColumns, whereClause, whereArgs,
                null, null, orderBy);

        while (c.moveToNext()) {
            if (c.getString(0).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void select(String id) {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("Select * from student where id = " + id, null);
        while (data.moveToNext()) {
            list.add(data.getString(1));
        }
        for (String str: list) {
            System.out.println(str);
        }
    }
}
