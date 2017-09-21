package com.neusoft.oddc.oddc.neusoft;

/**
 * Created by rsamonte on 9/6/2017.
 */

public class Constants
{
    public static class ODDCApp
    {
        public static final String BASE_URL = "http://52.52.124.97:8080//";
        public static final int PING_TIME = 10000;   //10 seconds

        public static String DATABASE_NAME = "oddc.db";

        public static int MIN_AVAIL_FS = 1024 * 1024 * 1024;
        public static int FRAME_RATE = 30;
        public static int SAMPLE_FREQ = 30;
        public static int FRAMES_PER_MIN = FRAME_RATE * 60;
        public static int SENDCOUNT = FRAMES_PER_MIN / SAMPLE_FREQ;

    }
}
