package com.example.juancarlos.adminbodegadai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juancarlos on 14/05/17.
 * Se crea la base da datos de los articulos
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table productos(codigo int primary key,clasificacion text,fabricante text,procedencia text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists productos");
        db.execSQL("create table productos(codigo int primary key,clasificacion text,fabricante text,procedencia text)");

    }
}
