package com.example.digitando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnJogar, btnSair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar = (Button) findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);

        btnSair = (Button) findViewById(R.id.btnSair);
        btnSair.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnJogar){
            Intent i = new Intent(this, Fases.class);
            startActivity(i);
            this.finish();
        }
        if (v == btnSair){
            Intent i = new Intent(this, Avancou_Nivel.class);
            startActivity(i);
            this.finish();
        }

    }
}
