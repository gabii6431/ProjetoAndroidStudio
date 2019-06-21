package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Avancou_Nivel extends Activity implements View.OnClickListener{
    private Button proximoNivel;
    private SharedPreferences preferencia;
    private int fase;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avancou__nivel);

        proximoNivel = (Button) findViewById(R.id.proximoNivel);
        proximoNivel.setOnClickListener(this);

        preferencia = getSharedPreferences("preferencia",0);
        fase = preferencia.getInt("fase",0);


    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor escritor = preferencia.edit();
        if(v == proximoNivel)
        {
            if(fase == 1)
            {
                Intent i = new Intent(this, Modulos_Medio.class);
                escritor.putInt("modulo", 0);
                escritor.putInt("palavra",0);
                escritor.putInt("fase",2);
                escritor.commit();
                startActivity(i);
                this.finish();
            }
            else if(fase == 2)
            {
                Intent i = new Intent(this, Modulos_Dificil.class);
                escritor.putInt("modulo", 0);
                escritor.putInt("palavra",0);
                escritor.putInt("fase",3);
                escritor.commit();
                startActivity(i);
                this.finish();
            }

        }
    }
}
