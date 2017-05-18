package com.example.juancarlos.adminbodegadai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        codigo = (EditText) findViewById(R.id.evCodigo);
    }


    //Inicio de sesion de los trabajadores
    public void accesoAlSistema(View v){
        Intent i  = new Intent(this,Main4Activity.class);
        String code = codigo.getText().toString();
        if (code.equals("157302")|| code.equals("157303")|| code.equals("157304")){
            startActivity(i);

        }else{
            Toast t= Toast.makeText(this,"Código incorrecto", Toast.LENGTH_LONG);
            t.show();

        }
    }
}
