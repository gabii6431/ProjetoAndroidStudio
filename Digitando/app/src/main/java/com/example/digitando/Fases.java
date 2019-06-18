package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fases extends Activity implements View.OnClickListener {
    private Button btnFacil, btnMedio, btnDificil;
    private SharedPreferences preferencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        preferencia = getSharedPreferences("preferencia",0);

        btnFacil = (Button) findViewById(R.id.btnFacil);
        btnFacil.setOnClickListener(this);

        btnMedio = (Button) findViewById(R.id.btnMedio);
        btnMedio.setOnClickListener(this);

        btnDificil = (Button) findViewById(R.id.btnDificil);
        btnDificil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        SharedPreferences.Editor escritor = preferencia.edit();

        if (v == btnFacil){
            escritor.putInt("fase", 1);
            escritor.commit();
            Intent i = new Intent(this, Modulos_Facil.class);
            startActivity(i);
        }
        if (v == btnMedio){
            escritor.putInt("fase", 2);
            escritor.commit();
            Intent i = new Intent(this, Modulos_Medio.class);
            startActivity(i);
        }
        if(v == btnDificil){
            escritor.putInt("fase", 3);
            escritor.commit();
//            Intent i = new Intent(this, Modulos_Dificil.class);
//            startActivity(i);

        }
    }
}
