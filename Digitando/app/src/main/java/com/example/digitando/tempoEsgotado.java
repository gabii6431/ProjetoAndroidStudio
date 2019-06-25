package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tempoEsgotado extends Activity implements View.OnClickListener {
    private Button btnTenteNovamente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo_esgotado);

        btnTenteNovamente = (Button) findViewById(R.id.btnTente);

    }

    @Override
    public void onClick(View v) {
        if(v == btnTenteNovamente){
            Intent i = new Intent(this,Palavras_Faceis.class);
            startActivity(i);
            this.finish();
        }
    }
}
