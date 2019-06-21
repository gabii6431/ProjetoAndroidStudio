package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProximoModulo extends Activity implements View.OnClickListener {
    private Button btnProximoModulo;
    private SharedPreferences preferencia;
    private int fase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximo_modulo);

        preferencia = getSharedPreferences("preferencia",0);
        fase = preferencia.getInt("fase",0);

        btnProximoModulo = (Button) findViewById(R.id.btnProximoModulo);
        btnProximoModulo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnProximoModulo){
            if(fase == 1)
            {
                Intent i = new Intent(this, Modulos_Facil.class);
                startActivity(i);
                this.finish();
            }
            else if(fase == 2)
            {
                Intent i = new Intent(this, Modulos_Medio.class);
                startActivity(i);
                this.finish();
            }
            else
            {
                Intent i = new Intent(this, Modulos_Dificil.class);
                startActivity(i);
                this.finish();
            }

        }
    }
}
