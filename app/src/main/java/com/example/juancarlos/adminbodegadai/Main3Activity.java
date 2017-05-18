package com.example.juancarlos.adminbodegadai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {


    private EditText codigoAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        codigoAdmin = (EditText) findViewById(R.id.evCodigoAdmin);
    }
    //Inicio de sesion de adminstrador
    public void accesoAlSistemaAdmin(View v) {
        Intent i = new Intent(this, Main6Activity.class);
        String code = codigoAdmin.getText().toString();
        if (code.equals("56821347")) {
            startActivity(i);

        } else {
            Toast t = Toast.makeText(this, "Código incorrecto", Toast.LENGTH_LONG);
            t.show();

        }
    }
}