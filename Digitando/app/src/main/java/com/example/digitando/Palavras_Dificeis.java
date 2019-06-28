package com.example.digitando;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Palavras_Dificeis extends Activity implements View.OnClickListener, MediaPlayer.OnCompletionListener, View.OnTouchListener{
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
    private TimerDificil timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palavras_dificeis);
        media = criaAudios();
        progress = (SeekBar) findViewById(R.id.seekBar);
        progress.setOnTouchListener(this);

        preferencia = getSharedPreferences("preferencia", 0);
        modulo = preferencia.getInt("modulo", 0);
        contPalavra = preferencia.getInt("palavra", 0);
        valorProgressBar = preferencia.getInt("progress", 0);
        progressBar1 = preferencia.getInt("progressMod1_Dificil", 0);
        progressBar2 = preferencia.getInt("progressMod2_Dificil", 0);
        progressBar3 = preferencia.getInt("progressMod3_Dificil", 0);
        progress.setProgress(valorProgressBar);

        //Cronometro
        txtTempoRestante = (TextView) findViewById(R.id.tempo);
        timer = new TimerDificil(this, txtTempoRestante, 1*60*1000, 1000);
        timer.start();


        media.get(contPalavra).setOnCompletionListener(this);
        media.get(contPalavra).start();

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

        tocaPalavra = (ImageButton) findViewById(R.id.tocaPalavra);
        tocaPalavra.setOnClickListener(this);

        palavraEscrita = (EditText) findViewById(R.id.palavraEscrita);
    }

    public ArrayList<MediaPlayer> criaAudios(){
        MediaPlayer ambicao, analogo, atraves, audacia, cinismo, empatia, excesso, inferir, recesso, sucinto, alicerce, ascensao, complexo, eminente, empirico, inerente, invasivo, metodico, premissa, prodigio, analitico, concepcao, concessao, escrupulo, hegemonia, paradigma, perspicaz, persuadir, proposito, reciproco;
        ambicao = MediaPlayer.create(this,R.raw.ambicao);
        analogo = MediaPlayer.create(this,R.raw.analogo);
        atraves = MediaPlayer.create(this,R.raw.atraves);
        audacia = MediaPlayer.create(this,R.raw.audacia);
        cinismo = MediaPlayer.create(this,R.raw.cinismo);
        empatia = MediaPlayer.create(this,R.raw.empatia);
        excesso = MediaPlayer.create(this,R.raw.excesso);
        inferir = MediaPlayer.create(this,R.raw.inferir);
        recesso = MediaPlayer.create(this,R.raw.recesso);
        sucinto = MediaPlayer.create(this,R.raw.sucinto);
        alicerce = MediaPlayer.create(this,R.raw.alicerce);
        ascensao = MediaPlayer.create(this,R.raw.ascensao);
        complexo = MediaPlayer.create(this,R.raw.complexo);
        eminente = MediaPlayer.create(this,R.raw.eminente);
        empirico = MediaPlayer.create(this,R.raw.empirico);

        inerente = MediaPlayer.create(this,R.raw.inerente);
        invasivo = MediaPlayer.create(this,R.raw.invasivo);
        metodico = MediaPlayer.create(this,R.raw.metodico);
        premissa = MediaPlayer.create(this,R.raw.premissa);
        prodigio = MediaPlayer.create(this,R.raw.prodigio);
        analitico = MediaPlayer.create(this,R.raw.analitico);
        concepcao = MediaPlayer.create(this,R.raw.concepcao);
        concessao = MediaPlayer.create(this,R.raw.concessao);
        escrupulo = MediaPlayer.create(this,R.raw.escrupulo);
        hegemonia = MediaPlayer.create(this,R.raw.hegemonia);
        paradigma = MediaPlayer.create(this,R.raw.paradigma);
        persuadir = MediaPlayer.create(this,R.raw.persuadir);
        perspicaz = MediaPlayer.create(this,R.raw.perspicaz);
        proposito = MediaPlayer.create(this,R.raw.proposito);
        reciproco = MediaPlayer.create(this,R.raw.reciproco);

        ArrayList<MediaPlayer> media = new ArrayList<MediaPlayer>(); // vetor de audios [0-9] - modulo 1 [10-19] - modulo 2 [20-29] - modulo 3

        media.add(ambicao);
        media.add(analogo);
        media.add(atraves);
        media.add(audacia);
        media.add(cinismo);
        media.add(empatia);
        media.add(excesso);
        media.add(inferir);
        media.add(recesso);
        media.add(sucinto);
        media.add(alicerce);
        media.add(ascensao);
        media.add(complexo);
        media.add(eminente);
        media.add(empirico);
        media.add(inerente);
        media.add(invasivo);
        media.add(metodico);
        media.add(premissa);
        media.add(prodigio);
        media.add(analitico);
        media.add(concepcao);
        media.add(concessao);
        media.add(escrupulo);
        media.add(hegemonia);
        media.add(paradigma);
        media.add(perspicaz);
        media.add(persuadir);
        media.add(proposito);
        media.add(reciproco);

        vetorPalavras.add("ambição");
        vetorPalavras.add("análogo");
        vetorPalavras.add("através");
        vetorPalavras.add("audácia");
        vetorPalavras.add("cinismo");
        vetorPalavras.add("empatia");
        vetorPalavras.add("excesso");
        vetorPalavras.add("inferir");
        vetorPalavras.add("recesso");
        vetorPalavras.add("sucinto");

        vetorPalavras.add("alicerce");
        vetorPalavras.add("ascensão");
        vetorPalavras.add("complexo");
        vetorPalavras.add("eminente");
        vetorPalavras.add("empírico");
        vetorPalavras.add("inerente");
        vetorPalavras.add("invasivo");
        vetorPalavras.add("metódico");
        vetorPalavras.add("premissa");
        vetorPalavras.add("prodígio");

        vetorPalavras.add("analítico");
        vetorPalavras.add("concepção");
        vetorPalavras.add("concessão");
        vetorPalavras.add("escrúpulo");
        vetorPalavras.add("hegemonia");
        vetorPalavras.add("paradigma");
        vetorPalavras.add("perspicaz");
        vetorPalavras.add("persuadir");
        vetorPalavras.add("propósito");
        vetorPalavras.add("recíproco");

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
                    escritor.putInt("progressMod1_Dificil", progressBar1);
                }
                else if(modulo == 2)
                {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar2+= 1;
                    escritor.putInt("progressMod2_Dificil", progressBar2);
                }
                else if(modulo == 3)
                {
                    Log.d("Tag", "Modulo que chegou: " + modulo);
                    progressBar3+= 1;
                    escritor.putInt("progressMod3_Dificil", progressBar3);
                }

                if(contPalavra == 29)
                {
                    escritor.putInt("progress", 0);
                    Intent i = new Intent(this,Jogo_Finalizado.class);
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
            if(cont != 2){
                media = null;
                media = criaAudios();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        media.get(contPalavra).start();
                    }
                }, 0);
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
                }, 0);
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

