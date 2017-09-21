package com.neusoft.oddc.widget;


import com.neusoft.oddc.BuildConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static final String getCurrentTime() {
        String timeStr = "";
        try {
            long time = System.currentTimeMillis(); //long now = android.os.SystemClock.uptimeMillis();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(time);
            timeStr = format.format(date);
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        }
        return timeStr;
    }


    public static final String getCurrentTime2() {
        String timeStr = "";
        try {
            long time = System.currentTimeMillis(); //long now = android.os.SystemClock.uptimeMillis();
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(time);
            timeStr = format.format(date);
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
        }
        return timeStr;
    }


}
