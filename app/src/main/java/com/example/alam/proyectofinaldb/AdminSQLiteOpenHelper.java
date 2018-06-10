package com.example.alam.proyectofinaldb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Data_utilities.creaTablaUsuarios);
        db.execSQL(Data_utilities.creaTablaPeliculas);
        db.execSQL(Data_utilities.creaTablaSeries);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + Data_utilities.tablaUsuarios);
        db.execSQL("drop table if exists " + Data_utilities.tablaPeliculas);
        db.execSQL("drop table if exists " + Data_utilities.tablaSeries);
        onCreate(db);
    }
}
