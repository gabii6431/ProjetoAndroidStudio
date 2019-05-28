package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Palavras_Faceis extends Activity implements View.OnClickListener {
    private Button btnEnviar;
    private SharedPreferences preferenciasModulo;
    private ArrayList<MediaPlayer> media = new ArrayList<MediaPlayer>(); // vetor de audios [0-9] - modulo 1 [10-19] - modulo 2 [20-29] - modulo 3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palavras__faceis);

        //verificar em qual palavra que o usuario esta;
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

        media = criaAudios();
        preferenciasModulo = getSharedPreferences("prefModulo",0);
    }

    public ArrayList<MediaPlayer> criaAudios(){
        MediaPlayer acao, afim, agil, agir, alfa, alto, amor, auge, aval, casa, cota, erro, fase, grau, joia, juiz, medo, nexo, odio, orla, pose, raso, ruim, seda, sede, sina, soar, trem, tudo, vida;
        acao = MediaPlayer.create(this,R.raw.acao);
        afim = MediaPlayer.create(this,R.raw.afim);
        agil = MediaPlayer.create(this,R.raw.agil);
        agir = MediaPlayer.create(this,R.raw.agir);
        alfa = MediaPlayer.create(this,R.raw.alfa);
        alto = MediaPlayer.create(this,R.raw.alto);
        amor = MediaPlayer.create(this,R.raw.amor);
        auge = MediaPlayer.create(this,R.raw.auge);
        aval = MediaPlayer.create(this,R.raw.aval);
        casa = MediaPlayer.create(this,R.raw.casa);

        cota = MediaPlayer.create(this,R.raw.cota);
        erro = MediaPlayer.create(this,R.raw.erro);
        fase = MediaPlayer.create(this,R.raw.fase);
        grau = MediaPlayer.create(this,R.raw.grau);
        joia = MediaPlayer.create(this,R.raw.joia);
        juiz = MediaPlayer.create(this,R.raw.juiz);
        medo = MediaPlayer.create(this,R.raw.medo);
        nexo = MediaPlayer.create(this,R.raw.nexo);
        odio = MediaPlayer.create(this,R.raw.odio);
        orla = MediaPlayer.create(this,R.raw.orla);

        pose = MediaPlayer.create(this,R.raw.pose);
        raso = MediaPlayer.create(this,R.raw.raso);
        ruim = MediaPlayer.create(this,R.raw.ruim);
        seda = MediaPlayer.create(this,R.raw.seda);
        sede = MediaPlayer.create(this,R.raw.sede);
        sina = MediaPlayer.create(this,R.raw.sina);
        soar = MediaPlayer.create(this,R.raw.soar);
        trem = MediaPlayer.create(this,R.raw.trem);
        tudo = MediaPlayer.create(this,R.raw.tudo);
        vida = MediaPlayer.create(this,R.raw.vida);

        ArrayList<MediaPlayer> media = new ArrayList<MediaPlayer>(); // vetor de audios [0-9] - modulo 1 [10-19] - modulo 2 [20-29] - modulo 3

        media.add(acao);
        media.add(afim);
        media.add(agil);
        media.add(agir);
        media.add(alfa);
        media.add(alto);
        media.add(amor);
        media.add(auge);
        media.add(aval);
        media.add(casa);
        media.add(cota);
        media.add(erro);
        media.add(fase);
        media.add(grau);
        media.add(joia);
        media.add(juiz);
        media.add(medo);
        media.add(nexo);
        media.add(odio);
        media.add(orla);
        media.add(pose);
        media.add(raso);
        media.add(ruim);
        media.add(seda);
        media.add(sede);
        media.add(sina);
        media.add(soar);
        media.add(trem);
        media.add(tudo);
        media.add(vida);

        return media;

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
