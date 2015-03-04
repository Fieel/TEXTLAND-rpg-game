package com.fieel.textland;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by diazm on 2/27/2015.
 */
public class LoadingScreen extends Activity {

    private RelativeLayout saveFileOneRL;
    private RelativeLayout saveFileTwoRL;
    private RelativeLayout saveFileThreeRL;
    private int selectedSaveFile;
    private boolean isNewGame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        final Bundle b = getIntent().getExtras();
        if(b != null && b.containsKey(StaticData.NEW_GAME)) {
            isNewGame = true;
        }
        saveFileOneRL = (RelativeLayout) findViewById(R.id.activity_loading_screen_save_one_rl);
        saveFileTwoRL = (RelativeLayout) findViewById(R.id.activity_loading_screen_save_two_rl);
        saveFileThreeRL = (RelativeLayout) findViewById(R.id.activity_loading_screen_save_three_rl);

        updateSaveFile(saveFileOneRL, 1);
        updateSaveFile(saveFileTwoRL, 2);
        updateSaveFile(saveFileThreeRL, 3);


        saveFileOneRL.setOnClickListener(saveFileListener);
        saveFileThreeRL.setOnClickListener(saveFileListener);
        saveFileTwoRL.setOnClickListener(saveFileListener);
        selectedSaveFile = -1;
    }

    private void updateSaveFile(RelativeLayout saveFileRL, int saveFileNo) {
        final String gameName = StaticData.getName(saveFileNo);

        final TextView nameTV = (TextView) saveFileRL.findViewById(R.id.layout_save_file_name_tv);
        final TextView deetsTV = (TextView) saveFileRL.findViewById(R.id.layout_save_file_deets_tv);
        final TextView timePlayedTV = (TextView) saveFileRL.findViewById(R.id.layout_save_file_name_tv);

        if(gameName != null && !gameName.equals("")) { // game exists
            final boolean gameIsMale = StaticData.isMale(saveFileNo);
            final int gameHP = StaticData.getHP(saveFileNo);
            final int gameFood = StaticData.getFood(saveFileNo);
            final int gameWater = StaticData.getWater(saveFileNo);
            final int gameSanity = StaticData.getSanity(saveFileNo);
            final int gameStamina = StaticData.getStamina(saveFileNo);
            final boolean gameEscape = StaticData.isEscape(saveFileNo);
            final int gameX = StaticData.getX(saveFileNo);
            final int gameY = StaticData.getY(saveFileNo);
            final int dayNo = StaticData.getDayNo(saveFileNo);


            final String gameDeets = String.format(getResources().getString(R.string.deets), gameStamina, gameWater, gameFood);
            final String dayNoStr = String.format(getResources().getString(R.string.days_cnt), dayNo);

            nameTV.setText(gameName);
            deetsTV.setText(gameDeets);
            timePlayedTV.setText(dayNoStr);
        }
        else {
            nameTV.setText(getResources().getString(R.string.no_save_file));
            deetsTV.setVisibility(View.GONE);
        }
    }

    private View.OnClickListener saveFileListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            saveFileOneRL.setBackgroundResource(id == saveFileOneRL.getId() ?
                    R.drawable.save_file_selected_background :
                    R.drawable.save_file_unselected_background);
            saveFileTwoRL.setBackgroundResource(id == saveFileTwoRL.getId() ?
                    R.drawable.save_file_selected_background :
                    R.drawable.save_file_unselected_background);
            saveFileThreeRL.setBackgroundResource(id == saveFileThreeRL.getId() ?
                    R.drawable.save_file_selected_background :
                    R.drawable.save_file_unselected_background);
            selectedSaveFile = id == saveFileOneRL.getId() ? 0 : id == saveFileTwoRL.getId() ? 1 : 2;
        }
    };

    public void loadGame(View view) {
        if(selectedSaveFile < 0) { // no game selected
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setMessage(R.string.error_no_save_file_selected)
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
            StaticData.setSaveFile(selectedSaveFile);
            final Intent intent = new Intent(LoadingScreen.this, NameActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
