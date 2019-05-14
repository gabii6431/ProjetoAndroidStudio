package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Palavras_Faceis extends Activity implements View.OnClickListener {
    private Button btnEnviar;
    private SharedPreferences preferenciasModulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palavras__faceis);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

        preferenciasModulo = getSharedPreferences("prefModulo",0);
    }

    @Override
    public void onClick(View v) {
        if(v == btnEnviar){
            SharedPreferences.Editor escritor = preferenciasModulo.edit();
            //Mudar aqui
            //verificar se palavra está certa
            if(true){
                escritor.putString("verifica","true");
            }else{
                escritor.putString("verifica","false");
            }
            escritor.commit();

            Intent i = new Intent(this, Tela_acertou.class);
            startActivity(i);
        }
    }
}
