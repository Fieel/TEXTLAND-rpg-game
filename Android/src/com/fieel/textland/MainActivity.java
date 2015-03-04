package com.fieel.textland;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by diazm on 2/27/2015.
 */
public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainn);


    }

    public void newGame(View view) {
        final Intent intent = new Intent(MainActivity.this, NameActivity.class);
        startActivity(intent);
    }

    public void continueGame(View view) {
        final Intent intent = new Intent(MainActivity.this, LoadingScreen.class);
        startActivity(intent);
    }
}
