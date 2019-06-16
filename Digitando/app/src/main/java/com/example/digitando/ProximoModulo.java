package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProximoModulo extends Activity implements View.OnClickListener {
    private Button btnProximoModulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximo_modulo);

        btnProximoModulo = (Button) findViewById(R.id.btnProximoModulo);
        btnProximoModulo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnProximoModulo){
            Intent i = new Intent(this, Modulos_Facil.class);
            startActivity(i);
        }
    }
}
