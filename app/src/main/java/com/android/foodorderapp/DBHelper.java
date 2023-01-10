package com.android.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "Loging.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table users(name TEXT,password TEXT,email TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists user");
    }

    public boolean insertData(String name, String password, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        contentValues.put("email",email);
        long result = db.insert("users",null,contentValues);
        if (result==-1)
          return  false;
        else
            return true;
    }
    public boolean checkUser(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ?",new String[]{email});
        if(cursor.getCount()>0)
          return true;
        else
            return false;
    }
    public  boolean checkEamilandPass(String password,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where password = ? and email = ?",new String[]{password,email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
