package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jogo_Finalizado extends Activity implements View.OnClickListener {
    private SharedPreferences preferencia;
    private Button btnFinal, btnReiniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_finalizado);

        btnFinal = findViewById(R.id.btnFinal);
        btnFinal.setOnClickListener(this);

        btnReiniciar = findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnFinal){
            Intent i= new Intent(this, MainActivity.class);
            startActivity(i);
            this.finish();
        }
        else if(v == btnReiniciar)
        {
            preferencia = getSharedPreferences("preferencia",0);
            preferencia.edit().clear().commit();
            Intent i= new Intent(this, MainActivity.class);
            startActivity(i);
            this.finish();
        }
    }
}
