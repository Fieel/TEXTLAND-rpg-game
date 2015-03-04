package com.fieel.textland;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by diazm on 2/26/2015.
 */
public class MaleFemaleActivity extends Activity {

    private ImageButton maleButton;
    private ImageButton femaleButton;
    private int maleSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_female);

        maleButton = (ImageButton) findViewById(R.id.activity_male_female_male_button);
        femaleButton = (ImageButton) findViewById(R.id.activity_male_female_female_button);
        maleSelected = -1;
    }


    public void genderSelect(View view) {
        final int id = view.getId();
        if(id == maleButton.getId()) {
            maleButton.setBackgroundResource(R.drawable.male_female_selected_background);
            femaleButton.setBackgroundResource(R.drawable.male_female_unselected_background);
            maleSelected = 1;
        }
        else {
            maleButton.setBackgroundResource(R.drawable.male_female_unselected_background);
            femaleButton.setBackgroundResource(R.drawable.male_female_selected_background);
            maleSelected = 0;
        }
    }

    public void genderContinue(View view) {
        if(maleSelected == -1) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder
                    .setMessage(R.string.error_no_gender_selected)
                    .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            final AlertDialog alertDialog = alertBuilder.create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.show();
        }
        else {
            final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            final String maleStr = getResources().getString(R.string.male);
            final String femaleStr = getResources().getString(R.string.female);
            final String genderSelectStr = String.format(getResources().getString(R.string.gender_select_msg),
                    maleSelected == 1 ? maleStr : femaleStr);
            alertBuilder
                    .setMessage(genderSelectStr)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            StaticData.setMale(maleSelected == 1);
                            StaticData.setX(StaticData.getRandomInt(StaticData.X_MAX)); // x=(int)(Math.random()*a.mapArray[0].length);
                            StaticData.setY(StaticData.Y_MAX - 1);  // y=a.mapArray.length-1;
                            final Intent intent = new Intent(MaleFemaleActivity.this, TempActivity.class);
                            startActivityForResult(intent, 9910);
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            final AlertDialog alertDialog = alertBuilder.create();
            alertDialog.setCanceledOnTouchOutside(true);

            alertDialog.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED) {
            if(StaticData.isMale()) {
                maleButton.setBackgroundResource(R.drawable.male_female_selected_background);
                femaleButton.setBackgroundResource(R.drawable.male_female_unselected_background);
                maleSelected = 1;
            }
            else {
                maleButton.setBackgroundResource(R.drawable.male_female_unselected_background);
                femaleButton.setBackgroundResource(R.drawable.male_female_selected_background);
                maleSelected = 0;
            }
        }
        else if(resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            finish();
        }
    }
}
