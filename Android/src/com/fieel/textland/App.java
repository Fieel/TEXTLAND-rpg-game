package com.fieel.textland;

import android.app.Application;

/**
 * Created by diazm on 2/27/2015.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        StaticData.setContext(this);
    }
}
