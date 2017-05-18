package com.example.juancarlos.adminbodegadai;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Main de los fragmentos

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment f1 = new FragmentoLista();
        ft.add(R.id.actividadPrincipal, f1);
        ft.commit();

        Fragment F2 = new BlankFragment();
        ft = fm.beginTransaction();
        ft.add(R.id.fragmento_agregar, F2);
        ft.commit();


    }
}
