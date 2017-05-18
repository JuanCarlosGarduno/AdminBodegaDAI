package com.example.juancarlos.adminbodegadai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by juancarlos y paco on 14/05/2017.
 * metodos para administrar la información en la bse de datos
 */
public class InterfazBD {

    ConexionBDtrabajadores con;
    SQLiteDatabase db;

    public InterfazBD(Context context){
        con = new ConexionBDtrabajadores(context);
    }

    public void open()throws SQLiteException{
        db= con.getWritableDatabase();
    }

    public void close() throws SQLiteException{
        con.close();
    }

    public long insertarDatos(String dato){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos",dato);
        long clave = db.insert("tablaTrabajadores",null,valores);
        close();
        return clave;
    }

    public void insertarDatosPrueba(){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos","Luis Santos");
        db.insert("tablaTrabajadores",null, valores);
        valores.put("datos","Rodrigo Huerta");
        db.insert("tablaTrabajadores",null, valores);
        valores.put("datos","Sergio Arnaud");
        db.insert("tablaTrabajadores",null, valores);
    }

    public String traerDato (long clave){
        open();
        String claveString =  Long.toString(clave);
        String query= "select * from tablaTrabajadores where _id="+ claveString+";";
        Cursor c = db.rawQuery(query,null);
        c.moveToNext();
        String res= c.getString(1);
        c.close();
        close();
        return res;
    }

    public Cursor traerDatos(){
        Cursor res = null;
        open();
        String query = "select * from tablaTrabajadores";
        res= db.rawQuery(query,null);
        if(res.getCount()==0){
            insertarDatosPrueba();
            res=db.rawQuery(query, null);
        }
        return res;
    }



}
