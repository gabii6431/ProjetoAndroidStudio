package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela_acertou extends Activity implements View.OnClickListener {

    private Button btnProximaPalavra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_acertou);

        btnProximaPalavra = (Button) findViewById(R.id.btnProximaPalavra);
        btnProximaPalavra.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnProximaPalavra){
            Intent i = new Intent(this, Palavras_Faceis.class);
            startActivity(i);
        }

    }
}
