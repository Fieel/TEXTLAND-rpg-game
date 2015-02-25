package com.fieel.textland;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private SharedPreferences prefs;
    private String constantUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        constantUsername = getResources().getString(R.string.constant_username);

        boolean containsUsername = prefs.contains(getResources().getString(R.string.constant_username));
        if(containsUsername) { // no need to ask for name
            launchTempActivity();
        }
    }

    private void launchTempActivity() {
        final Intent intent = new Intent(MainActivity.this, TempActivity.class);
        final String usernameEntered = prefs.getString(getResources().getString(R.string.constant_username), "");

        intent.putExtra(constantUsername, usernameEntered);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void nameContinue(View view) {
        final EditText nameEditText = (EditText) findViewById(R.id.activity_main_name_et);
        final String userName = nameEditText.getText().toString();
        if(userName == null || userName.equals("") || userName.matches("^.*[^a-zA-Z0-9 ].*$")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
            alertBuilder.setMessage(R.string.error_name)
                    .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.setCanceledOnTouchOutside(true);

            alertDialog.show();

        }
        else {
            prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            final SharedPreferences.Editor editor = prefs.edit();
            final String constantUsername = getResources().getString(R.string.constant_username);
            editor.putString(constantUsername, userName);
            editor.apply();
        }
    }
}
