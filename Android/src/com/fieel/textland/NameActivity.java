package com.fieel.textland;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class NameActivity extends Activity {
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nameContinue(View view) {
        final EditText nameEditText = (EditText) findViewById(R.id.activity_main_name_et);
        final String userName = nameEditText.getText().toString();
        if(userName == null || userName.equals("") || userName.matches("^.*[^a-zA-Z0-9 ].*$")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(NameActivity.this);
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
            StaticData.setName(userName);
            final Intent intent = new Intent(NameActivity.this, MaleFemaleActivity.class);
            startActivityForResult(intent, 9099);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final TextView tv = (TextView) findViewById(R.id.activity_main_name_et);

        if(resultCode == RESULT_CANCELED) {
            tv.setText(StaticData.getName());
        }
        else if (resultCode == RESULT_OK) {
            finish();
        }
    }


}
