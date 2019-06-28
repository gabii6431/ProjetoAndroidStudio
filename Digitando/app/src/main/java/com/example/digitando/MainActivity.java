package com.example.digitando;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private SharedPreferences preferencia;
    private Button btnJogar, btnSair, btnReiniciar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar = (Button) findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);

        btnSair = (Button) findViewById(R.id.btnSair);
        btnSair.setOnClickListener(this);

        btnReiniciar1 = (Button) findViewById(R.id.btnReiniciar1);
        btnReiniciar1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnJogar){
            Intent i = new Intent(this, Fases.class);
            startActivity(i);
        }
        if (v == btnSair){
            this.finish();
        }
        if (v == btnReiniciar1)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Reiniciar jogo");
            builder.setMessage("Você tem certeza que deseja reiniciar o jogo?");
            //define um botão como positivo
            builder.setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    preferencia = getSharedPreferences("preferencia",0);
                    preferencia.edit().clear().commit();
                    Toast.makeText(MainActivity.this, "Jogo Reiniciado", Toast.LENGTH_SHORT).show();
                }
            });
            //define um botão como negativo.
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        }

    }
}
