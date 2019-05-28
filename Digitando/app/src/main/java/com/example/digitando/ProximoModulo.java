package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
    }

    @Override
    public void onClick(View v) {
        if(v == btnProximoModulo){
            //receber a shared preference para poder ver em qual nivel está
            //ver qual janela de nivel vai abrir
        }
    }
}
