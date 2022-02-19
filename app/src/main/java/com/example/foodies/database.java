package com.example.foodies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname = "zomato.db"; //--name of com.example.foodie.database

    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q = "create table users(_id integer primary key autoincrement,phone int,password text)";
        sqLiteDatabase.execSQL(q);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }
    public boolean insert_data(String phone,String password) {
        SQLiteDatabase ds = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("phone", phone);
        c.put("password", password);
        long r = ds.insert("users",null,c);
        if (r == -1)
            return false;
        else
            return true;

    }
    public boolean checkphone(String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select*from users where phone = ?",new String[]{phone});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public boolean checkpassword(String phone,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select*from users where phone = ? and password = ?",new String[]{phone,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public boolean updatepassword(String password) {
        SQLiteDatabase df = this.getWritableDatabase();
        ContentValues d = new ContentValues();
        d.put("password", password);
        long r = df.update("users",d,"password==?",new String[]{password});
        if (r == -1)
            return false;
        else
            return true;
    }

}



