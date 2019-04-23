package com.example.digitando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Modulos_Facil extends AppCompatActivity implements View.OnClickListener {
    private Button btnJogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos__facil);

        btnJogar = (Button) findViewById(R.id.btnJogar2);
        btnJogar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnJogar){
            Intent i = new Intent(this, Palavras_Faceis.class);
            startActivity(i);
        }
    }
}
