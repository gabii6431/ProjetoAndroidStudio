package com.example.digitando;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MyCountDownTimer extends CountDownTimer {
    private Context context;
    private TextView tv;
    private long timeInFuture;

    public MyCountDownTimer(Context context, TextView tv, long timeInFuture,long interval){
        super(timeInFuture, interval);
        this.tv = tv;
        this.context = context;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        Log.d("TAG", "Timer: "+millisUntilFinished);
        timeInFuture = millisUntilFinished;
        tv.setText(getCorretcTimer(true,millisUntilFinished)+":"+getCorretcTimer(false,millisUntilFinished));
    }

    @Override
    public void onFinish() {
        timeInFuture -= 1000;
        tv.setText(getCorretcTimer(true,timeInFuture)+":"+getCorretcTimer(false,timeInFuture));
        Intent i = new Intent(context,tempoEsgotado.class);
        context.startActivity(i);
    }

    private String getCorretcTimer(boolean isMinute, long millisUntilFinished){
        String aux;
        int constCalendar = isMinute ? Calendar.MINUTE : Calendar.SECOND;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisUntilFinished);

        aux = c.get(constCalendar) < 10 ? "0"+c.get(constCalendar) : ""+c.get(constCalendar);
        return  aux;
    }
}
