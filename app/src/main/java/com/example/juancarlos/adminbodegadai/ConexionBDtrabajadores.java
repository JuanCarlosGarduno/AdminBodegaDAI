package com.example.juancarlos.adminbodegadai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juancarlos y paco on 14/05/2017.
 * Se crea la base da datos de los articulos
 */
public class ConexionBDtrabajadores extends SQLiteOpenHelper{

    String cadenaCreate="create table if not exists tablaTrabajadores(_id integer primary key autoincrement, datos text not null)";

    public ConexionBDtrabajadores(Context context) {
        super(context, "prueba.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cadenaCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String cadenaUpdate="drop table if exists tablaTrabajadores";
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }
}
