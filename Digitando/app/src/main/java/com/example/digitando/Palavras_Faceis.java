package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;

public class Palavras_Faceis extends Activity implements View.OnClickListener, MediaPlayer.OnCompletionListener, View.OnTouchListener {
    private Button btnEnviar;
    private int contPalavra; //variavel para controlar qual palavra o usuario esta atualmente no jogo
    private EditText palavraEscrita;
    private SharedPreferences preferencia; //variavel utilizada para salvar o estado do jogo
    private ArrayList<MediaPlayer> media = new ArrayList<MediaPlayer>(); // vetor de audios ([0-9] - modulo 1 [10-19] - modulo 2 [20-29] - modulo 3)
    private ImageButton tocaPalavra;
    private ArrayList<String> vetorPalavras = new ArrayList<String>();
    private SeekBar progress;
    private int cont = 0;
    private int valorProgressBar;
    private int modulo;
    private int progressBar1, progressBar2, progressBar3;
    private int tempoRestante = 0, maxTempo = 65;
    private TextView txtTempoRestante;
    private String tempoString = "";
    private ConstraintLayout constraint;
    private MyCountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        media = criaAudios();
        setContentView(R.layout.activity_palavras__faceis);

        progress = (SeekBar) findViewById(R.id.seekBar);
        progress.setOnTouchListener(this);

        preferencia = getSharedPreferences("preferencia",0);
        //preferencia.edit().clear().commit();
        modulo = preferencia.getInt("modulo", 0);
        contPalavra = preferencia.getInt("palavra",0);
        valorProgressBar = preferencia.getInt("progress", 0);
        progressBar1 = preferencia.getInt("progressMod1_Facil", 0);
        progressBar2 = preferencia.getInt("progressMod2_Facil", 0);
        progressBar3 = preferencia.getInt("progressMod3_Facil", 0);
        progress.setProgress(valorProgressBar);
        Log.d("Tag", "progressBar1: " + progressBar1);
        Log.d("Tag", "progressBar2: " + progressBar2);
        Log.d("Tag", "progressBar3: " + progressBar3);
        Log.d("Tag", "ValorProgress: " + valorProgressBar);
        Log.d("Tag", "ContPalavra " + contPalavra);

        Log.d("Tag", "ContPalavra " +Integer.toString(contPalavra));
        Log.d("Tag", "Modulo que chegou" + Integer.toString(modulo));

        //constraint = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_palavras__faceis,null);

        txtTempoRestante = (TextView) findViewById(R.id.tempo);
        timer = new MyCountDownTimer(this, txtTempoRestante, 1*60*1000, 1000);
        timer.start();

        //verificar em qual modulo ele esta
        //se modulo 1 - ir no vetor de 0-9
        //se modulo 2 - ir no vetor de 10-19
        //se modulo 3 - ir no  vetor de 20-29

        media.get(contPalavra).setOnCompletionListener(this);
        media.get(contPalavra).start();

        //verificar em qual palavra que o usuario esta;
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

        tocaPalavra = (ImageButton) findViewById(R.id.tocaPalavra);
        tocaPalavra.setOnClickListener(this);

        palavraEscrita = (EditText) findViewById(R.id.palavraEscrita);
        //tempoRestante = maxTempo;
        //Handler htempo = new Handler();

        /*htempo.postDelayed(new Runnable() {
            @Override
            public void run() {
                while(tempoRestante  > 0){
                    if (tempoRestante < 60){
                        Log.d("TAG", Integer.toString(tempoRestante));
                        tempoString = Integer.toString(tempoRestante);
                        txtTempoRestante.setText(tempoString);
                    }
                    tempoRestante--;
                }
            }
        }, 1000);*/



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

        vetorPalavras.add("ação");
        vetorPalavras.add("afim");
        vetorPalavras.add("ágil");
        vetorPalavras.add("agir");
        vetorPalavras.add("alfa");
        vetorPalavras.add("alto");
        vetorPalavras.add("amor");
        vetorPalavras.add("auge");
        vetorPalavras.add("aval");
        vetorPalavras.add("casa");
        vetorPalavras.add("cota");
        vetorPalavras.add("erro");
        vetorPalavras.add("fase");
        vetorPalavras.add("grau");
        vetorPalavras.add("joia");
        vetorPalavras.add("juiz");
        vetorPalavras.add("medo");
        vetorPalavras.add("nexo");
        vetorPalavras.add("ódio");
        vetorPalavras.add("orla");
        vetorPalavras.add("pose");
        vetorPalavras.add("raso");
        vetorPalavras.add("ruim");
        vetorPalavras.add("seda");
        vetorPalavras.add("sede");
        vetorPalavras.add("sina");
        vetorPalavras.add("soar");
        vetorPalavras.add("trem");
        vetorPalavras.add("tudo");
        vetorPalavras.add("vida");

        return media;

    }

    @Override
    public void onClick(View v) {
        if(v == btnEnviar)
        {
            cont = 0;
            SharedPreferences.Editor escritor = preferencia.edit();
            Log.d("Tag",vetorPalavras.get(contPalavra));
            Log.d("Tag",palavraEscrita.getText().toString());
            if(palavraEscrita.getText().toString().equals(vetorPalavras.get(contPalavra)))
            {
                if(modulo == 1)
                {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar1+= 1;
                    escritor.putInt("progressMod1_Facil", progressBar1);
                }
                else if(modulo == 2)
                {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar2+= 1;
                    escritor.putInt("progressMod2_Facil", progressBar2);
                }
                else if(modulo == 3) {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar3 += 1;
                    escritor.putInt("progressMod3_Facil", progressBar3);
                }

                if(contPalavra == 29)
                {
                    escritor.putInt("progress", 0);
                    Intent i = new Intent(this,Avancou_Nivel.class);
                    startActivity(i);
                    this.finish();
                }
                else if(valorProgressBar == 9)
                {
                    escritor.putInt("progress", 0);
                    Intent i = new Intent(this,ProximoModulo.class);
                    startActivity(i);
                    this.finish();
                }
                else
                {
                    Log.d("Tag", "Entrei aq");
                    progress.setProgress(valorProgressBar++);
                    escritor.putInt("progress", valorProgressBar++);
                    Intent i = new Intent(this,Tela_acertou.class);
                    startActivity(i);
                }
                contPalavra++;
                escritor.putInt("palavra", contPalavra);
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
                //media.get(contPalavra).stop();
                media = null;
                media = criaAudios();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        media.get(contPalavra).start();
                    }
                }, 1000);
                //media.get(contPalavra).setOnCompletionListener(this);
                cont++;
            }
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(timer != null){
            timer.cancel();
        }

    }

}
