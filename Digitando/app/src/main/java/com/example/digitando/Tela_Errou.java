package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela_Errou extends Activity implements View.OnClickListener {

    private Button btnTentaNovamente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__errou);

        btnTentaNovamente = (Button) findViewById(R.id.btnTenteNovamente);
        btnTentaNovamente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnTentaNovamente)
        {
            Intent i = new Intent(this, Palavras_Faceis.class);
            startActivity(i);
        }
    }
}
