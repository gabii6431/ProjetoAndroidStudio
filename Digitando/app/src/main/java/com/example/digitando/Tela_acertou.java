package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela_acertou extends Activity implements View.OnClickListener {

    private Button btnProximaPalavra;
    private SharedPreferences preferencia;
    private int fase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_acertou);

        preferencia = getSharedPreferences("preferencia",0);
        fase = preferencia.getInt("fase",0);

        btnProximaPalavra = (Button) findViewById(R.id.btnProximaPalavra);
        btnProximaPalavra.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnProximaPalavra){
            if(fase == 1)
            {
                Intent i = new Intent(this, Palavras_Faceis.class);
                startActivity(i);
            }
            else if(fase == 2){
                Intent i = new Intent(this, Palavras_Medias.class);
                startActivity(i);
            }
            else
            {
//                Intent i = new Intent(this, Palavras_Dificeis.class);
//                startActivity(i);
            }

        }

    }
}
