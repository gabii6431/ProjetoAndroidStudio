package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Palavras_Medias extends Activity implements View.OnClickListener, MediaPlayer.OnCompletionListener, View.OnTouchListener{

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

    private TextView txtTempoRestante;
    private MyCountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palavras_medias);
        media = criaAudios();
        progress = (SeekBar) findViewById(R.id.seekBar);
        progress.setOnTouchListener(this);

        preferencia = getSharedPreferences("preferencia", 0);
        modulo = preferencia.getInt("modulo", 0);
        contPalavra = preferencia.getInt("palavra", 0);
        valorProgressBar = preferencia.getInt("progress", 0);
        progressBar1 = preferencia.getInt("progressMod1_Medio", 0);
        progressBar2 = preferencia.getInt("progressMod2_Medio", 0);
        progressBar3 = preferencia.getInt("progressMod3_Medio", 0);
        progress.setProgress(valorProgressBar);

        media.get(contPalavra).setOnCompletionListener(this);
        media.get(contPalavra).start();

        //Cronometro
        txtTempoRestante = (TextView) findViewById(R.id.tempo);
        timer = new MyCountDownTimer(this, txtTempoRestante, 1*70*1000, 1000);
        timer.start();

        //verificar em qual palavra que o usuario esta;
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

        tocaPalavra = (ImageButton) findViewById(R.id.tocaPalavra);
        tocaPalavra.setOnClickListener(this);

        palavraEscrita = (EditText) findViewById(R.id.palavraEscrita);
    }

    public ArrayList<MediaPlayer> criaAudios(){
        MediaPlayer ansia, etica, expor, icone, ideia, mexer, mutua, nobre, plena, porem, sagaz, senso, sutil, vicio, vigor, alheio, ambito, anseio, casual, cinico, comico, eficaz, enfase, exceto, faccao, habito, nocivo, objeto, ocioso, pressa;
        ansia = MediaPlayer.create(this,R.raw.ansia);
        etica = MediaPlayer.create(this,R.raw.etica);
        expor = MediaPlayer.create(this,R.raw.expor);
        icone = MediaPlayer.create(this,R.raw.icone);
        ideia = MediaPlayer.create(this,R.raw.ideia);
        mexer = MediaPlayer.create(this,R.raw.mexer);
        mutua = MediaPlayer.create(this,R.raw.mutua);
        nobre = MediaPlayer.create(this,R.raw.nobre);
        plena = MediaPlayer.create(this,R.raw.plena);
        porem = MediaPlayer.create(this,R.raw.porem);
        sagaz = MediaPlayer.create(this,R.raw.sagaz);
        senso = MediaPlayer.create(this,R.raw.senso);
        sutil = MediaPlayer.create(this,R.raw.sutil);
        vicio = MediaPlayer.create(this,R.raw.vicio);
        vigor = MediaPlayer.create(this,R.raw.vigor);

        alheio = MediaPlayer.create(this,R.raw.alheio);
        ambito = MediaPlayer.create(this,R.raw.ambito);
        anseio = MediaPlayer.create(this,R.raw.anseio);
        casual = MediaPlayer.create(this,R.raw.casual);
        cinico = MediaPlayer.create(this,R.raw.cinico);
        comico = MediaPlayer.create(this,R.raw.comico);
        eficaz = MediaPlayer.create(this,R.raw.eficaz);
        enfase = MediaPlayer.create(this,R.raw.enfase);
        exceto = MediaPlayer.create(this,R.raw.exceto);
        faccao = MediaPlayer.create(this,R.raw.faccao);
        habito = MediaPlayer.create(this,R.raw.habito);
        objeto = MediaPlayer.create(this,R.raw.objeto);
        nocivo = MediaPlayer.create(this,R.raw.nocivo);
        ocioso = MediaPlayer.create(this,R.raw.ocioso);
        pressa = MediaPlayer.create(this,R.raw.pressa);

        ArrayList<MediaPlayer> media = new ArrayList<MediaPlayer>(); // vetor de audios [0-9] - modulo 1 [10-19] - modulo 2 [20-29] - modulo 3

        media.add(ansia);
        media.add(etica);
        media.add(expor);
        media.add(icone);
        media.add(ideia);
        media.add(mexer);
        media.add(mutua);
        media.add(nobre);
        media.add(plena);
        media.add(porem);
        media.add(sagaz);
        media.add(senso);
        media.add(sutil);
        media.add(vicio);
        media.add(vigor);
        media.add(alheio);
        media.add(ambito);
        media.add(anseio);
        media.add(casual);
        media.add(cinico);
        media.add(comico);
        media.add(eficaz);
        media.add(enfase);
        media.add(exceto);
        media.add(faccao);
        media.add(habito);
        media.add(objeto);
        media.add(nocivo);
        media.add(ocioso);
        media.add(pressa);

        vetorPalavras.add("ânsia");
        vetorPalavras.add("ética");
        vetorPalavras.add("expor");
        vetorPalavras.add("ícone");
        vetorPalavras.add("ideia");
        vetorPalavras.add("mexer");
        vetorPalavras.add("mútua");
        vetorPalavras.add("nobre");
        vetorPalavras.add("plena");
        vetorPalavras.add("porém");
        vetorPalavras.add("sagaz");
        vetorPalavras.add("senso");
        vetorPalavras.add("sutil");
        vetorPalavras.add("vicío");
        vetorPalavras.add("vigor");

        vetorPalavras.add("alheio");
        vetorPalavras.add("âmbito");
        vetorPalavras.add("anseio");
        vetorPalavras.add("casual");
        vetorPalavras.add("cinico");
        vetorPalavras.add("cômico");
        vetorPalavras.add("eficaz");
        vetorPalavras.add("ênfase");
        vetorPalavras.add("exceto");
        vetorPalavras.add("facção");
        vetorPalavras.add("hábito");
        vetorPalavras.add("objeto");
        vetorPalavras.add("nocivo");
        vetorPalavras.add("ocioso");
        vetorPalavras.add("pressa");

        return media;

    }

    @Override
    public void onClick(View v) {
        if(v == btnEnviar)
        {
            cont = 0;
            SharedPreferences.Editor escritor = preferencia.edit();
            if(palavraEscrita.getText().toString().equals(vetorPalavras.get(contPalavra)))
            {
                if(modulo == 1)
                {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar1+= 1;
                    escritor.putInt("progressMod1_Medio", progressBar1);
                }
                else if(modulo == 2)
                {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar2+= 1;
                    escritor.putInt("progressMod2_Medio", progressBar2);
                }
                else if(modulo == 3)
                {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar3+= 1;
                    escritor.putInt("progressMod3_Medio", progressBar3);
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
            if(cont != 2){
                media = null;
                media = criaAudios();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        media.get(contPalavra).start();
                    }
                }, 200);
                cont++;
            }
            else if(cont == 2){
                media = null;
                media = criaAudios();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        media.get(contPalavra).start();
                    }
                }, 200);
                cont++;
                tocaPalavra.setImageResource(R.drawable.mudo);
                tocaPalavra.setEnabled(false);
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

