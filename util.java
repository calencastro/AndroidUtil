package br.com.hangar55.archery2go.helper;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by calencastro on 24/07/2017.
 */

public final class util {

    public util() {

    }

    public static String fromUnixtoFormatedString(long unixEpoch) {
        String data = "";
        data = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(unixEpoch));
        return data;
    }


    public static long fromFormatedStringtoUnix(String date) {
        return fromFormatedStringtoUnix(date, "00:00");
    }

    public static long fromFormatedStringtoUnix(String date, String time) {
        long unixEpoch = 0;

        String str = date + " " + time;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date typeDate = null;
        try {
            typeDate = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        unixEpoch = typeDate.getTime();

        return unixEpoch;
    }


    public static long currentEpoch() {
        Long currentEpoch = System.currentTimeMillis();
        return currentEpoch;
    }

    public static String getTodayDate() {
        final Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String textMonth;
        String textDay;
        if (month < 10) {
            textMonth = "0" + month;
        } else {
            textMonth = String.valueOf(month);
        }

        if (day < 10) {
            textDay = "0" + day;
        } else {
            textDay = String.valueOf(day);
        }
        return textDay + "/" + textMonth + "/" + c.get(Calendar.YEAR);
    }

    public static void setCurrentTreino(Context context, int id) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("currentTreino", String.valueOf(id));
        editor.commit();
    }

    public static int getCurrentTreino(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return Integer.valueOf(sharedPreferences.getString("currentTreino", "-1"));

    }

    public static void setLastRound(Context context, int id) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("pref_last_round_id", String.valueOf(id));
        editor.commit();

    }

    public static int getLastRound(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return Integer.valueOf(sharedPreferences.getString("pref_last_round_id", "-1"));
    }
}
