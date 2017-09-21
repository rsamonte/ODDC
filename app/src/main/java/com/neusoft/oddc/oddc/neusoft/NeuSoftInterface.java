package com.neusoft.oddc.oddc.neusoft;

// NeuSoft callbacks which ODDC invokes to send data to NeuSoft
public interface NeuSoftInterface {
    public void onFLAparam(int param); // TBD
    public void sentToFLA(int param);

    public void stop();  // stop ADAS & DVR
    public void resume(); // resume ADAS & DVR
}
