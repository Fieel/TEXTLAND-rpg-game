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

        final String gameName = StaticData.getName();
        final boolean gameMale = StaticData.isMale();

        final TextView tv = (TextView) findViewById(R.id.tbc_tv);
        tv.setText(String.format(getResources().getString(R.string.your_name_is),
                    gameName,
                    gameMale ? getResources().getString(R.string.male) : getResources().getString(R.string.female)
                ));
        tv.setText(getResources().getString(R.string.start_moving));


    }

    private static void renderCurrentEnv() {
        StaticData.getEnvironment();
    }
}
