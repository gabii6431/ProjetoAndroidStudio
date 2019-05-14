package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Modulos_Facil extends Activity implements View.OnClickListener {
    private Button btnJogar;
    private ProgressBar progressModulo1;
    private SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencias = getSharedPreferences("prefModulo",0);
        String verifica = preferencias.getString("verifica", null);

        if(verifica == "true"){
            progressModulo1.setProgress(progressModulo1.getProgress()+1);

        }

        setContentView(R.layout.activity_modulos__facil);

        btnJogar = (Button) findViewById(R.id.btnJogar2);
        btnJogar.setOnClickListener(this);


        progressModulo1 = (ProgressBar) findViewById(R.id.progressModulo1);


    }

    @Override
    public void onClick(View v) {
        if (v == btnJogar){
            Intent i = new Intent(this, Palavras_Faceis.class);
            startActivity(i);
        }
    }
}
