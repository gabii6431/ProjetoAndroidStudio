package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fases extends Activity implements View.OnClickListener {
    private Button btnFacil, btnMedio, btnDificil;
    private SharedPreferences preferencia;
    private int valorProgress_Facil, valorProgress_Medio, valorProgress_Dificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        preferencia = getSharedPreferences("preferencia",0);
        //preferencia.edit().clear().commit();
        valorProgress_Facil = preferencia.getInt("progressMod3_Facil",0);
        valorProgress_Medio = preferencia.getInt("progressMod3_Medio",0);
        valorProgress_Dificil = preferencia.getInt("progressMod3_Dificil",0);

        btnFacil = (Button) findViewById(R.id.btnFacil);
        btnFacil.setOnClickListener(this);

        btnMedio = (Button) findViewById(R.id.btnMedio);
        btnMedio.setOnClickListener(this);

        btnDificil = (Button) findViewById(R.id.btnDificil);
        btnDificil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        SharedPreferences.Editor escritor = preferencia.edit();

        if (v == btnFacil) {
            if (valorProgress_Facil == 10) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Finalizou o nível Fácil");
                builder.setMessage("Você já finalizou o nível Fácil, tente ir para o nível Médio!");
                builder.create().show();
            } else {
                escritor.putInt("fase", 1);
                escritor.commit();
                Intent i = new Intent(this, Modulos_Facil.class);
                startActivity(i);
            }
        }
        if (v == btnMedio) {
            if (valorProgress_Facil != 10) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Não finalizou nível Fácil");
                builder.setMessage("Você ainda não finalizou o nível Fácil!");
                builder.create().show();
            }
            if (valorProgress_Medio == 10) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Finalizou o nível Médio");
                builder.setMessage("Você já finalizou o nível Médio, tente ir para o nível Difícil!");
                builder.create().show();
            } else {
                escritor.putInt("fase", 2);
                escritor.commit();
                Intent i = new Intent(this, Modulos_Medio.class);
                startActivity(i);
            }

        }
        if (v == btnDificil) {
            if (valorProgress_Facil != 10) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Não finalizou nível Fácil");
                builder.setMessage("Você ainda não finalizou o nível Fácil!");
                builder.create().show();
            }
            else if (valorProgress_Medio != 10) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Não finalizou nível Médio");
                builder.setMessage("Você ainda não finalizou o nível Médio!");
                builder.create().show();
            }
            if (valorProgress_Dificil == 10){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Você já finalizou o jogo");
                builder.setMessage("Aguarde Atualizações!");
                builder.create().show();
            }
            else {
                escritor.putInt("fase", 3);
                escritor.commit();
                Intent i = new Intent(this, Modulos_Dificil.class);
                startActivity(i);
            }
        }
    }
}
