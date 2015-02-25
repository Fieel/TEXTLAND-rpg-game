package com.fieel.textland;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

/**
 * Created by Miguel on 2/25/2015.
 */
public class TempActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tbc);

        final Bundle b = getIntent().getExtras();
        String name = "";
        final String constantUsername = getResources().getString(R.string.constant_username);
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        if(b != null && b.containsKey(constantUsername)) {
            name = b.getString(constantUsername);
        }
        else {
            name = prefs.getString(constantUsername, "");
        }

        final TextView tv = (TextView) findViewById(R.id.tbc_tv);
        tv.setText(String.format(getResources().getString(R.string.your_name_is), name));
    }
}
