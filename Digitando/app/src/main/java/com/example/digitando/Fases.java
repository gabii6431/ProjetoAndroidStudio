package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fases extends Activity implements View.OnClickListener {
    private Button btnFacil, btnMedio, btnDificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        btnFacil = (Button) findViewById(R.id.btnFacil);
        btnFacil.setOnClickListener(this);

        btnMedio = (Button) findViewById(R.id.btnMedio);
        btnMedio.setOnClickListener(this);

        btnDificil = (Button) findViewById(R.id.btnDificil);
        btnDificil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == btnFacil){
            Intent i = new Intent(this, Modulos_Facil.class);
            startActivity(i);
        }
        if (v == btnMedio){

        }
        if(v == btnDificil){

        }
    }
}
