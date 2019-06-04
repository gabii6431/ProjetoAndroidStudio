package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Palavras_Faceis extends Activity implements View.OnClickListener, MediaPlayer.OnCompletionListener {
    private Button btnEnviar;
    private int contPalavra;
    private EditText palavraEscrita;
    private boolean modulo1 = false , modulo2 = false , modulo3 = false;
    private SharedPreferences preferencia;
    private ArrayList<MediaPlayer> media = new ArrayList<MediaPlayer>(); // vetor de audios [0-9] - modulo 1 [10-19] - modulo 2 [20-29] - modulo 3
    private ImageButton tocaPalavra;
    private int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        media = criaAudios();
        setContentView(R.layout.activity_palavras__faceis);

        preferencia = getSharedPreferences("preferencia",0);
        int modulo = preferencia.getInt("modulo", 0);
        contPalavra = preferencia.getInt("palavra",0);

        //verificar em qual modulo ele esta
        //se modulo 1 - ir no vetor de 0-9
        //se modulo 2 - ir no vetor de 10-19
        //se modulo 3 - ir no  vetor de 20-29

        if(modulo == 1 && !modulo1)
        {
            contPalavra = 0;
            modulo1 = true;
        }
        else if(modulo == 2 && !modulo2)
        {
            contPalavra = 10;
            modulo2 = true;
        }
        else if (modulo == 3 && !modulo3)
        {
            contPalavra = 20;
            modulo3 = true;
        }

        media.get(contPalavra).setOnCompletionListener(this);
        media.get(contPalavra).start();

        //verificar em qual palavra que o usuario esta;
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

        tocaPalavra = (ImageButton) findViewById(R.id.tocaPalavra);
        tocaPalavra.setOnClickListener(this);

        palavraEscrita = (EditText) findViewById(R.id.palavraEscrita);
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
        if(v == btnEnviar)
        {
            cont = 0;
            SharedPreferences.Editor escritor = preferencia.edit();
            escritor.putInt("palavra", contPalavra);
            if(palavraEscrita == vetorPalavras[contPalavra])
            {
                contPalavra++;
                Intent i = new Intent(this,Tela_acertou.class);
                startActivity(i);

            }
            else{
                Intent i = new Intent(this,Tela_Errou.class);
                startActivity(i);
            }
            escritor.commit();
            this.finish();
        }
        if(v == tocaPalavra)
        {
            if(cont != 3){
                media.get(contPalavra).setOnCompletionListener(this);
                media.get(contPalavra).start();
                cont++;
            }
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }
}
