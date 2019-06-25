package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TempoEsgotadoMedio extends Activity implements View.OnClickListener {
    private Button btnTenteNovamenteMedio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo_esgotado_medio);


        btnTenteNovamenteMedio = (Button) findViewById(R.id.btnTenteMedio);
        btnTenteNovamenteMedio.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnTenteNovamenteMedio){
            Intent i = new Intent(this,Palavras_Medias.class);
            startActivity(i);
            this.finish();
        }
    }
}
