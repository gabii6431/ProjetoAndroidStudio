package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Avancou_Nivel extends Activity implements View.OnClickListener{
    private Button proximoNivel;
    private SharedPreferences preferencia;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avancou__nivel);

        proximoNivel = (Button) findViewById(R.id.proximoNivel);
        proximoNivel.setOnClickListener(this);

        preferencia = getSharedPreferences("preferencia",0);

    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor escritor = preferencia.edit();
        if(v == proximoNivel)
        {
            Intent i = new Intent(this, Modulos_Medio.class);
            escritor.putInt("modulo", 0);
            escritor.commit();
            startActivity(i);
        }
    }
}
