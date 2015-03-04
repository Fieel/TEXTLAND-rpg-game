package com.fieel.textland;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by diazm on 2/26/2015.
 */
public class StaticData {

    public static StaticData data;
    private static Context m_context;
    private static SharedPreferences m_prefs;
    private static SharedPreferences.Editor m_editor;
    // global vars
    private static String m_name;

    private static boolean m_isMale;
    private static int m_HP = 100;  //CHARACTER STARTING VITAL HIT POINTS
    private static int m_food = 100;       //CHARACTER STARTING FOOD
    private static int m_water = 100;      //CHARACTER STARTING WATER
    private static int m_sanity = 100;     //CHARACTER MENTAL SANITY
    private static int m_stamina = 100;    //CHARACTER STARTING STAMINA
    private static boolean m_escape = false;
    private static int m_x;
    private static int m_y;
    private static int saveFile;
    private static int m_dayNo;
    private static int[][] m_map;
    public static final String NAME_STR = "NAME";

    public static final String ISMALE_STR = "ISMALE";
    public static final String HP_STR = "HP";
    public static final String FOOD_STR = "FOOD";
    public static final String WATER_STR = "WATER";
    public static final String SANITY_STR = "SANITY";
    public static final String STAMINA_STR = "STAMINA";
    public static final String ESCAPE_STR = "ESCAPE";
    public static final String X_STR = "X";
    public static final String Y_STR = "Y";
    public static final String DAY_STR = "DAY";
    public static final String MAP_STR = "MAP";
    public static final String SAVE_FILE = "SAVEFILE";
    public static final String NEW_GAME = "newgame";

    public static final int X_MAX = 10;
    public static final int Y_MAX = 10;
    public static final int PROBABILITY_MAX = 100;

    public static Random m_random;
    private static void environment;


    private StaticData() {}

    public static void setContext(final Context context) {
        m_context = context;
        m_prefs = PreferenceManager.getDefaultSharedPreferences(m_context);
        m_editor = m_prefs.edit();
        m_random = new Random();
        saveFile = 0;

    }

    public static StaticData getInstance() {
        if(data == null) {
            data = new StaticData();
            final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(m_context);
            m_name = prefs.getString(NAME_STR + saveFile, "");
            m_isMale = prefs.getBoolean(ISMALE_STR + saveFile, false);
            m_HP = prefs.getInt(HP_STR + saveFile, 100);
            m_food = prefs.getInt(FOOD_STR + saveFile, 100);
            m_sanity = prefs.getInt(SANITY_STR + saveFile, 100);
            m_stamina = prefs.getInt(STAMINA_STR + saveFile, 100);
            m_escape = prefs.getBoolean(ESCAPE_STR + saveFile, false);
            m_x = prefs.getInt(X_STR + saveFile, 0);
            m_y = prefs.getInt(Y_STR + saveFile, 0);
            m_dayNo = prefs.getInt(DAY_STR + saveFile, 0);
            mapStrToIntInt(prefs.getString(MAP_STR + saveFile, ""));
        }
        return data;
    }

    private static void mapStrToIntInt(String string) {

        for(int i = 0; i < X_MAX; i++) {
            for(int j = 0; j < Y_MAX; j++) {
                m_map[i][j] = string.charAt(X_MAX * i + j);
            }
        }
    }

    private static String mapIntIntToStr() {
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < X_MAX; i++) {
            for(int j = 0; j < Y_MAX; j++) {
                sb.append(String.valueOf(m_map[i][j]));
            }
        }
        return sb.toString();
    }

    public static String getName() {
        return m_name;
    }

    public static String getName(int saveFileNo) {
        return m_prefs.getString(NAME_STR + saveFileNo, "");
    }

    public static boolean isMale() {
        return m_isMale;
    }

    public static boolean isMale(int saveFileNo) {
        return m_prefs.getBoolean(ISMALE_STR + saveFileNo, false);
    }

    public static int getHP() {
        return m_HP;
    }

    public static int getHP(int saveFileNo) {
        return m_prefs.getInt(HP_STR + saveFileNo, 0);
    }

    public static int getFood() {
        return m_food;
    }

    public static int getFood(int saveFileNo) {
        return m_prefs.getInt(FOOD_STR + saveFileNo, 0);
    }

    public static int getWater() {
        return m_water;
    }

    public static int getWater(int saveFileNo) {
        return m_prefs.getInt(WATER_STR + saveFileNo, 0);
    }

    public static int getSanity() {
        return m_sanity;
    }

    public static int getSanity(int saveFileNo) {
        return m_prefs.getInt(SANITY_STR + saveFileNo, 0);
    }

    public static int getStamina() {
        return m_stamina;
    }

    public static int getStamina(int saveFileNo) {
        return m_prefs.getInt(STAMINA_STR + saveFileNo, 0);
    }

    public static boolean isEscape() {
        return m_escape;
    }

    public static boolean isEscape(int saveFileNo) {
        return m_prefs.getBoolean(ESCAPE_STR + saveFileNo, false);
    }

    public static int getX() {
        return m_x;
    }

    public static int getX(int saveFileNo) {
        return m_prefs.getInt(X_STR + saveFileNo, 0);
    }

    public static int getY() {
        return m_y;
    }

    public static int getY(int saveFileNo) {
        return m_prefs.getInt(Y_STR + saveFileNo, 0);
    }

    public static int getDayNo() {
        return m_dayNo;
    }

    public static int getDayNo(int saveFileNo) {
        return m_prefs.getInt(DAY_STR + saveFileNo, 0);
    }

    public static void setY(int y) {
        m_y = y;
    }

    public static void setName(String name) {
        m_name = name;
        m_editor.putString(NAME_STR + saveFile, m_name).apply();
    }

    public static void setMale(boolean isMale) {
        m_isMale = isMale;
        m_editor.putBoolean(ISMALE_STR + saveFile, m_isMale).apply();
    }

    public static void setHP(int HP) {
        m_HP = HP;
        m_editor.putInt(HP_STR + saveFile, m_HP).apply();
    }

    public static void incrementHP(int incrHP) {
        m_HP = m_HP + incrHP;
        m_editor.putInt(HP_STR + saveFile, m_HP).apply();
    }

    public static void reduceHP(int incrHP) {
        m_HP = m_HP - incrHP;
        m_editor.putInt(HP_STR + saveFile, m_HP).apply();
    }

    public static void setFood(int food) {
        m_food = food;
        m_editor.putInt(FOOD_STR + saveFile, m_food).apply();
    }

    public static void incrementFood(int incrFood) {
        m_food = m_food + incrFood;
        m_editor.putInt(FOOD_STR + saveFile, m_food).apply();
    }

    public static void reduceFood(int reduceFood) {
        m_food = m_food + reduceFood;
        m_editor.putInt(FOOD_STR + saveFile, m_food).apply();
    }

    public static void setWater(int water) {
        m_water = water;
        m_editor.putInt(WATER_STR + saveFile, m_water).apply();
    }

    public static void incrementWater(int incrWater) {
        m_water = m_water + incrWater;
        m_editor.putInt(WATER_STR + saveFile, m_water).apply();
    }

    public static void reduceWater(int reduceWater) {
        m_water = m_water + reduceWater;
        m_editor.putInt(WATER_STR + saveFile, m_water).apply();
    }

    public static void setSanity(int sanity) {
        m_sanity = sanity;
        m_editor.putInt(SANITY_STR + saveFile, m_sanity).apply();
    }

    public static void incrementSanity(int incrSanity) {
        m_sanity = m_sanity + incrSanity;
        m_editor.putInt(SANITY_STR + saveFile, m_sanity).apply();
    }

    public static void reduceSanity(int reduceSanity) {
        m_sanity = m_sanity + reduceSanity;
        m_editor.putInt(SANITY_STR + saveFile, m_sanity).apply();
    }

    public static void setStamina(int stamina) {
        m_stamina = stamina;
        m_editor.putInt(WATER_STR + saveFile, m_water).apply();
    }

    public static void incrementStamina(int incrStamina) {
        m_stamina = m_stamina + incrStamina;
        m_editor.putInt(STAMINA_STR + saveFile, m_stamina).apply();
    }

    public static void reduceStamina(int reduceStamina) {
        m_stamina = m_stamina + reduceStamina;
        m_editor.putInt(STAMINA_STR + saveFile, m_stamina).apply();
    }

    public static void setEscape(boolean escape) {
        m_escape = escape;
        m_editor.putBoolean(ESCAPE_STR + saveFile, m_escape).apply();
    }

    public static void setX(int x) {
        m_x = x;
        m_editor.putInt(X_STR + saveFile, m_x).apply();
    }

    public static void setDayNo(int dayNo) {
        m_dayNo = dayNo;
        m_editor.putInt(DAY_STR + saveFile, m_dayNo).apply();
    }

    public static void setSaveFile(int saveFileNo) {
        saveFile = saveFileNo;
        if(!m_prefs.contains(NAME_STR + saveFileNo)) { // new file; create
            data = new StaticData();
            createMap();
            final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(m_context);
            m_editor.putString(NAME_STR + saveFile, "")
                .putBoolean(ISMALE_STR + saveFile, false)
                .putInt(HP_STR + saveFile, 100)
                .putInt(FOOD_STR + saveFile, 100)
                .putInt(SANITY_STR + saveFile, 100)
                .putInt(STAMINA_STR + saveFile, 100)
                .putBoolean(ESCAPE_STR + saveFile, false)
                .putInt(X_STR + saveFile, 0)
                .putInt(Y_STR + saveFile, 0)
                .putInt(DAY_STR + saveFile, 0)
                .putString(MAP_STR + saveFileNo, mapIntIntToStr())
                .apply();
            setName("");
            setMale(false);
            setHP(100);
            setFood(100);
            setSanity(100);
            setStamina(100);
            setEscape(false);
            setX(0);
            setY(0);
            setDayNo(0);
        }
    }

    private static void createMap() {
        final Random random = new Random();
        for(int i = 0; i < X_MAX; i++) {
            for(int j = 0; j < Y_MAX; j++) {
                m_map[i][j] = random.nextInt(10);
            }
        }
    }

    public static int getRandomInt(int max) {
        return m_random.nextInt(max);
    }

    public static void getEnvironment() {
        int cell = m_map[m_x][m_y];
        switch (cell){
            case 0: Environment.village();
                break;
            case 1: Environment.forest();
                break;
            case 2: Environment.river();
                break;
            case 3: Environment.cave();
                break;
            case 4: Environment.castle();
                break;
            case 5: Environment.plains();
                break;
            case 6: Environment.mountain();
                break;
            case 7: Environment.swamp();
                break;
            case 8: Environment.crypta();
                break;
            case 9: Environment.countryside();
                break;
            default:
                Environment.village(); // bugs but should handle it appropriately anyway
                break;
        }
        return environment;
    }
}
