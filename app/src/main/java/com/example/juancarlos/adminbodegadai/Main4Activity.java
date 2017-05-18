package com.example.juancarlos.adminbodegadai;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//Funcionalidad de alta, enviar(baja),etc para la base de datos de articulos

public class Main4Activity extends AppCompatActivity {



    private EditText codigo;
    private EditText clasif;
    private EditText fab;
    private EditText proced;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        codigo = (EditText) findViewById(R.id.etCodigo);
        clasif = (EditText) findViewById(R.id.etClasif);
        fab = (EditText) findViewById(R.id.etFab);
        proced = (EditText) findViewById(R.id.etProced);

    }

    public void limpiar (View v){
        codigo.setText("");
        clasif.setText("");
        fab.setText("");
        proced.setText("");
    }

    public void alta (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Permisos de escritura a la base de datos
        String code = codigo.getText().toString();
        String clasific = clasif.getText().toString();
        String fabri = fab.getText().toString();
        String proc = proced.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", code);
        registro.put("clasificacion", clasific);
        registro.put("fabricante", fabri);
        registro.put("procedencia", proc);
        db.insert("productos", null, registro);
        db.close();
        limpiar(v);
        Toast.makeText(this, "Se agregaron los datos a la base", Toast.LENGTH_LONG).show();
    }

    public void baja(View v){
        Intent i = new Intent(this, Main5Activity.class);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de escritura a la base de datos
        String clave = codigo.getText().toString();
        int cant = db.delete("productos","codigo=" + clave, null);
        if(cant == 1){
            Toast.makeText(this, "Se borró el producto de la base con el código dado", Toast.LENGTH_LONG).show();
            startActivity(i);
            startService(i);
        }
        else
            Toast.makeText(this, "No existe el producto", Toast.LENGTH_LONG).show();
        db.close();
        limpiar(v);

    }

    public void enviar(View v){
        Intent i = new Intent(this, Main5Activity.class);
        startActivity(i);
        startService(i);
    }

}
