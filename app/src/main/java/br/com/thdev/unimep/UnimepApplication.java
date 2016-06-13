package br.com.thdev.unimep;

import android.app.Application;
import android.util.Log;

/**
 * Created by thiag on 02/05/2016.
 */
public class UnimepApplication extends Application{
    private static final String TAG = "CarrosApplication";
    private static UnimepApplication instance = null;

    public UnimepApplication getInstance(){
        return instance; //Singleton
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "UnimepApplication.onCreate()");
        //Salva a instancia para termos de acesso como singleton
        instance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "UnimepApplication.onTerminate()");
    }
}
