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
        //preferencia.edit().clear().commit();
        int palavra = preferencia.getInt("palavra", 0);
        Log.d("Tag", "Palavra "+Integer.toString(palavra));

        btnJogar = (Button) findViewById(R.id.btnJogar2);
        btnJogar.setOnClickListener(this);

        progressModulo1 = (ProgressBar) findViewById(R.id.progressModulo1);
        progressModulo2 = (ProgressBar) findViewById(R.id.progressModulo2);
        progressModulo3 = (ProgressBar) findViewById(R.id.progressModulo3);

        valorProgressBar1 = preferencia.getInt("progressMod1", 0);
        valorProgressBar2 = preferencia.getInt("progressMod2", 0);
        valorProgressBar3 = preferencia.getInt("progressMod3", 0);

        progressModulo1.setProgress(valorProgressBar1);
        progressModulo2.setProgress(valorProgressBar2);
        progressModulo3.setProgress(valorProgressBar3);


        if(palavra == 0 || palavra == 1 || palavra == 2 || palavra == 3 || palavra == 4 || palavra == 5 || palavra == 6 || palavra == 7 || palavra == 8 || palavra == 9)
        {
            modulo = 1;
            SharedPreferences.Editor escritorMod1 = preferencia.edit();
            progressModulo1.setProgress(valorProgressBar1++);
            escritorMod1.putInt("progressMod1", valorProgressBar1++);
            escritorMod1.commit();

        }
        else if(palavra == 10|| palavra == 11 || palavra == 12 || palavra == 13 || palavra == 14 || palavra == 15 || palavra == 16 || palavra == 17 || palavra == 18 || palavra == 19)
        {
            modulo = 2;
            SharedPreferences.Editor escritorMod2 = preferencia.edit();
            progressModulo2.setProgress(valorProgressBar2++);
            escritorMod2.putInt("progressMod1", valorProgressBar2++);
            escritorMod2.commit();


        }
        else if(palavra == 20|| palavra == 21 || palavra == 22 || palavra == 23 || palavra == 24 || palavra == 25 || palavra == 26 || palavra == 27 || palavra == 28 || palavra == 29)
        {
            modulo = 3;
            SharedPreferences.Editor escritorMod3 = preferencia.edit();
            progressModulo3.setProgress(valorProgressBar3++);
            escritorMod3.putInt("progressMod1", valorProgressBar3++);
            escritorMod3.commit();
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
