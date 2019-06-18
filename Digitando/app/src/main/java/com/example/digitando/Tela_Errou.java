package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela_Errou extends Activity implements View.OnClickListener {

    private Button btnTentaNovamente;
    private SharedPreferences preferencia;
    private int fase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__errou);

        preferencia = getSharedPreferences("preferencia",0);
        fase = preferencia.getInt("fase",0);

        btnTentaNovamente = (Button) findViewById(R.id.btnTenteNovamente);
        btnTentaNovamente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnTentaNovamente)
        {
            if(fase == 1)
            {
                Intent i = new Intent(this, Palavras_Faceis.class);
                startActivity(i);
                this.finish();
            }
            else if(fase == 2)
            {
                Intent i = new Intent(this, Palavras_Medias.class);
                startActivity(i);
                this.finish();
            }
            else
            {
//                Intent i = new Intent(this, Palavras_Dificeis.class);
//                startActivity(i);
//                this.finish();
            }

        }
    }
}
