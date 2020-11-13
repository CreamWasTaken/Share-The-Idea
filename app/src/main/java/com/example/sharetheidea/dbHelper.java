package com.example.sharetheidea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    public static String DB_Name = "DB_LIST";
    public static String TBLName ="TBL_LIST";

    public dbHelper(@Nullable Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("Create table " + TBLName + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Username text,Password Text,Name text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS " + TBLName);
        onCreate(db);
    }

    public boolean InsertData(String username, String password, String name){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues Cv = new ContentValues();
        Cv.put("Username",username);
        Cv.put("Password",password);
        Cv.put("Name",name);
        long result = myDb.insert(TBLName,null,Cv);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }

    }

    public Cursor viewData(){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor res = myDb.rawQuery("Select * from " + TBLName,null);
        return res;
    }

    public boolean LoginData(String UN,String PW){
        SQLiteDatabase myDb = this.getWritableDatabase();

        Cursor res = myDb.rawQuery("Select * from " + TBLName + " where Username  =\"" + UN + "\" and Password = \"" + PW + "\"",null);
        if (res.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}
