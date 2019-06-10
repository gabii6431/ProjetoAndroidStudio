package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Modulos_Facil extends Activity implements View.OnClickListener {
    private Button btnJogar;
    private ProgressBar progressModulo1, progressModulo2, progressModulo3;
    private SharedPreferences preferencia;
    private int valorProgressBar1, valorProgressBar2, valorProgressBar3;
    private int modulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos__facil);

        preferencia = getSharedPreferences("preferencia",0);
        int palavra = preferencia.getInt("palavra", 0);
        Log.d("Tag", "Palavra "+Integer.toString(palavra));

        btnJogar = (Button) findViewById(R.id.btnJogar2);
        btnJogar.setOnClickListener(this);

        progressModulo1 = (ProgressBar) findViewById(R.id.progressModulo1);
        progressModulo2 = (ProgressBar) findViewById(R.id.progressModulo2);
        progressModulo3 = (ProgressBar) findViewById(R.id.progressModulo3);

        if(palavra == 0 || palavra == 1 || palavra == 2 || palavra == 3 || palavra == 4 || palavra == 5 || palavra == 6 || palavra == 7 || palavra == 8 || palavra == 9)
        {
            modulo = 1;
            valorProgressBar1 = progressModulo1.getProgress();
            if(valorProgressBar1 == 10)
            {
                Intent i = new Intent(this,ProximoModulo.class);
                startActivity(i);
                this.finish();
            }
            else
            {
                progressModulo1.setProgress(valorProgressBar1++);
            }


//            if(progressModulo1.getProgress() == 10){
//                if(progressModulo2.getProgress() != 10){
//                    progressModulo2.setProgress(progressModulo2.getProgress()+1);
//                }else if(progressModulo2.getProgress()  == 10){
//                    if(progressModulo3.getProgress() != 10){
//                        progressModulo3.setProgress(progressModulo3.getProgress()+1);
//                    }else if(progressModulo3.getProgress() == 10){
//                        //mandar um shared preference que passou para o nivel 2
//                    }
//                }
//            }else if(progressModulo1.getProgress() != 10){
//                progressModulo1.setProgress(progressModulo1.getProgress()+1);
//            }
        }
        else if(palavra == 10|| palavra == 11 || palavra == 12 || palavra == 13 || palavra == 14 || palavra == 15 || palavra == 16 || palavra == 17 || palavra == 18 || palavra == 19)
        {
            modulo = 2;
            valorProgressBar2 = progressModulo2.getProgress();
            if(valorProgressBar2 == 10)
            {
                Intent i = new Intent(this,ProximoModulo.class);
                startActivity(i);
                this.finish();
            }
            else
            {
                progressModulo2.setProgress(valorProgressBar2++);
            }


        }
        else if(palavra == 20|| palavra == 21 || palavra == 22 || palavra == 23 || palavra == 24 || palavra == 25 || palavra == 26 || palavra == 27 || palavra == 28 || palavra == 29)
        {
            modulo = 3;
            valorProgressBar3 = progressModulo3.getProgress();
            if(valorProgressBar3 == 10)
            {
                Intent i = new Intent(this,ProximoModulo.class);
                startActivity(i);
                this.finish();
            }
            else
            {
                progressModulo3.setProgress(valorProgressBar3++);
            }
        }

    }

    @Override
    public void onClick(View v) {
        if (v == btnJogar){
            SharedPreferences.Editor escritor = preferencia.edit();
            escritor.putInt("modulo", modulo);
            escritor.commit();
            Log.d("Tag", "Modulo1" + Integer.toString(modulo));
            Intent i = new Intent(this, Palavras_Faceis.class);
            startActivity(i);
        }
    }
}
