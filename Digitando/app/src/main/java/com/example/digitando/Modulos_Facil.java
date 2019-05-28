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
    private ProgressBar progressModulo1, progressModulo2, progressModulo3;
    private SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos__facil);
        preferencias = getSharedPreferences("prefModulo",0);
        String verifica = preferencias.getString("verifica", null);

        btnJogar = (Button) findViewById(R.id.btnJogar2);
        btnJogar.setOnClickListener(this);

        progressModulo1 = (ProgressBar) findViewById(R.id.progressModulo1);
        progressModulo2 = (ProgressBar) findViewById(R.id.progressModulo2);
        progressModulo3 = (ProgressBar) findViewById(R.id.progressModulo3);

        if(verifica == "true"){
            if(progressModulo1.getProgress() == 10){
                if(progressModulo2.getProgress() != 10){
                    progressModulo2.setProgress(progressModulo2.getProgress()+1);
                }else if(progressModulo2.getProgress()  == 10){
                    if(progressModulo3.getProgress() != 10){
                        progressModulo3.setProgress(progressModulo3.getProgress()+1);
                    }else if(progressModulo3.getProgress() == 10){
                        //mandar um shared preference que passou para o nivel 2
                    }
                }
            }else if(progressModulo1.getProgress() != 10){
                progressModulo1.setProgress(progressModulo1.getProgress()+1);
            }
        }

    }

    @Override
    public void onClick(View v) {
        if (v == btnJogar){
            Intent i = new Intent(this, Palavras_Faceis.class);
            startActivity(i);
        }
    }
}
