package com.example.evaluacion2aac.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class Evaluacion2AACApplication extends Application {
    private static Evaluacion2AACApplication instance;
    private static Context appContext;

    public static Evaluacion2AACApplication getInstance() {return instance;}
    public static Context getAppContext(){return appContext;}
    public void SetAppContext(Context mAppContext){this.appContext = mAppContext;}

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

        this.SetAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
