package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TempoEsgotadoDificil extends Activity implements View.OnClickListener {
    private Button btnTenteNovamenteDificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo_esgotado_dificil);

        btnTenteNovamenteDificil = (Button) findViewById(R.id.btnTenteDificil);
        btnTenteNovamenteDificil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnTenteNovamenteDificil){
            Intent i = new Intent(this,Palavras_Medias.class);
            startActivity(i);
            this.finish();
        }
    }
}
