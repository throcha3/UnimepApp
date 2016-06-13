package br.com.thdev.unimep.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import br.com.thdev.unimep.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Timer 3 seg
        Thread timerThread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent (SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
        timerThread.start();
    }

    //Executa toda vez que a activity é deixada em segundo plano
    @Override
    protected void onPause() {
        super.onPause();
        finish();//Finaliza act para o usuario não voltar pra ela
    }

}
