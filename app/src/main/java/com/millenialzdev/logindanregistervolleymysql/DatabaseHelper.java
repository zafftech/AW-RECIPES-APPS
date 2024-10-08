package com.millenialzdev.logindanregistervolleymysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "SignLog.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "SignLog.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        // Updated table structure with id, fullname, userid, and password
        MyDatabase.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, fullname TEXT, userid TEXT UNIQUE, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS users");
        onCreate(MyDB);
    }

    // Insert new user data into the SQLite database
    public Boolean insertData(String fullname, String userid, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullname);
        contentValues.put("userid", userid);
        contentValues.put("password", password);
        long result = MyDatabase.insert("users", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Check if a userid already exists in the database
    public Boolean checkUserid(String userid) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE userid = ?", new String[]{userid});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Check if a userid and password match in the database
    public Boolean checkUseridPassword(String userid, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE userid = ? AND password = ?", new String[]{userid, password});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
