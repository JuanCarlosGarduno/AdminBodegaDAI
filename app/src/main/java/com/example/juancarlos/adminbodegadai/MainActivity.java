package com.example.juancarlos.adminbodegadai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarTrab(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void enviarAdmin(View v){
        Intent i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }

}
