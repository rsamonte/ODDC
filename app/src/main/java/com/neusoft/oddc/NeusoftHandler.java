package com.neusoft.oddc;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.neusoft.oddc.adas.ADASHelper;
import com.neusoft.oddc.entity.Constants;
import com.neusoft.oddc.oddc.model.ContinuousData;
import com.neusoft.oddc.oddc.neusoft.NeuSoftInterface;
import com.neusoft.oddc.oddc.neusoft.ODDCclass;
import com.neusoft.oddc.oddc.neusoft.PlaybackList;
import com.neusoft.oddc.widget.PropertyUtil;
import com.neusoft.oddc.widget.eventbus.EventStartDataCollection;
import com.neusoft.oddc.widget.eventbus.EventStopDataCollection;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class NeusoftHandler implements NeuSoftInterface {

    private static final String TAG = ADASHelper.class.getSimpleName();

    private static Context mContext;
    private static ODDCclass oddCclass;
    public static boolean isOddcOk = false;

    private ADASHelper adasHelper;

    // for data transfer between Neusoft and ODDC
    public void onFLAparam(int param) {
    } // example only at this time, param(s) TBD

    public NeusoftHandler(Context context) {
        mContext = context;
    }

    public NeusoftHandler() {
    }

    public static Context getContext() {
        return mContext;
    }

    public void sentToFLA(int param) {
        Log.d(TAG, "SentToFLA return " + param);
    }

    public void resume() {
        EventBus.getDefault().post(new EventStartDataCollection());
    }

    public void stop() {
        EventBus.getDefault().post(new EventStopDataCollection());
    }


    public void init(Context context) {
//        String url = context.getString(R.string.base_url);
        String url = PropertyUtil.getServerUrl();
        File videodir = new File(Constants.FILE_PATH);
        oddCclass = new ODDCclass(url, context, videodir);
        oddCclass.setListener(this);
        adasHelper = new ADASHelper(context);
    }

    public boolean startupOddcClass() {
        if (null != oddCclass) {
            isOddcOk = oddCclass.ok2Startup();
        }
        return isOddcOk;
    }

    public boolean postContinuousData(ContinuousData data) {
        if (null == oddCclass) {
            return false;
        }
        return oddCclass.onContinuousData(data);
    }

    public boolean shutdownOddc() {
        boolean isShutDownSuccess = false;
        if (null != oddCclass) {
            isShutDownSuccess = oddCclass.reqShutdown();
            oddCclass = null;
            isOddcOk = false;
        }
        return isShutDownSuccess;
    }

//    public List<String> getContinuousLog() {
//        List<String> list;
//        if (null == oddCclass || !isOddcOk) {
//            Log.e(TAG, "oddc is not ok!");
//            list = new ArrayList<String>();
//        } else {
//            list = oddCclass.getContinuousLog();
//            if (null != list) {
//                Log.d(TAG, "oddc trace -> continuous begin --------------- ");
//                for (String contiuousItem : list) {
//                    Log.d(TAG, "oddc trace -> contiuousItem = " + contiuousItem);
//                }
//                Log.d(TAG, "oddc trace -> continuous end --------------- ");
//            }
//        }
//        return list;
//    }

//    public List<String> getEventLog() {
//        List<String> list;
//        if (null == oddCclass || !isOddcOk) {
//            Log.e(TAG, "oddc is not ok!");
//            list = new ArrayList<String>();
//        } else {
//            list = oddCclass.getEventLog();
//            if (null != list) {
//                Log.d(TAG, "oddc trace -> event begin --------------- ");
//                for (String eventItem : list) {
//                    Log.d(TAG, "oddc trace -> eventItem = " + eventItem);
//                }
//                Log.d(TAG, "oddc trace -> event end --------------- ");
//            }
//        }
//        return list;
//    }


//    public List<String> getOnDemandLog() {
//        List<String> list;
//        if (null == oddCclass || !isOddcOk) {
//            Log.e(TAG, "oddc is not ok!");
//            list = new ArrayList<String>();
//        } else {
//            list = oddCclass.getOnDemandLog();
//            if (null != list) {
//                Log.d(TAG, "oddc trace -> onDemand begin --------------- ");
//                for (String onDemandItem : list) {
//                    Log.d(TAG, "oddc trace -> onDemandItem = " + onDemandItem);
//                }
//                Log.d(TAG, "oddc trace -> onDemand end --------------- ");
//            }
//        }
//        return list;
//    }

    public ArrayList<PlaybackList> getPlaybackList() {
        ArrayList<PlaybackList> list;
        if (null == oddCclass || !isOddcOk) {
            Log.e(TAG, "oddc is not ok!");
            list = new ArrayList<PlaybackList>();
        } else {
            list = oddCclass.getPlaybackList();
            Log.d(TAG, "oddCclass.getPlaybackList over");
            if (null != list) {
                Log.d(TAG, "oddc trace -> playbacklist begin --------------- ");
                Log.d(TAG, "list size is " + list.size());
                for (PlaybackList mPlaybackList : list) {
                    Log.d(TAG, "oddc trace playbacklist-> MediaURI = " + mPlaybackList.MediaURI);
                    Log.d(TAG, "oddc trace playbacklist-> GShockEvent = " + mPlaybackList.GShockEvent);
                    Log.d(TAG, "oddc trace playbacklist-> FCWEvent = " + mPlaybackList.FCWEvent);
                    Log.d(TAG, "oddc trace playbacklist-> LDWEvent = " + mPlaybackList.LDWEvent);
                    Log.d(TAG, "oddc trace playbacklist-> MediaDeleted = " + mPlaybackList.MediaDeleted);
                }
                Log.d(TAG, "oddc trace -> playbacklist end --------------- ");
            }
        }
        return list;
    }

    public static ContinuousData mkContinuousData(String currentFileName, double accelerationX, double accelerationY, double accelerationZ) {
        Timestamp dateTime = new Timestamp(new Date().getTime());

        // NeuSoft prepares data for transfer somewhere in their code
        ContinuousData cd = new ContinuousData();

        //Create dummy data
        cd.vehicleID = ADASHelper.getvin(); // VIN
        //cd.timezone = 0;

        cd.gpsTimeStamp = dateTime; // from OS not GPS
        Location location = ADASHelper.getCoarseLocation();
        if (null != location) {
            double mLongitude = location.getLongitude();
            double mLatitude = location.getLatitude();
            cd.longitude = mLongitude;
            cd.latitude = mLatitude;
            cd.gpsTimeStamp = new Timestamp(location.getTime());
        } else {
            cd.longitude = 0;
            cd.latitude = 0;
        }

        cd.speed = ADASHelper.getspd();
        cd.speedDetectionType = 0; // always be ZERO

        cd.accelerationTimeStamp = dateTime; /* yyyy-MM-dd HH:mm:ss.SSS for SQLite */
        cd.accelerationX = accelerationX;
        cd.accelerationX = accelerationX;
        cd.accelerationZ = accelerationZ;

        cd.gShockTimeStamp = dateTime;
        cd.gShockEvent = false;
        //cd.gShockEventThreshold = getRandomFloat(); /* might be a parameter from FLA */

        cd.fcwTimeStamp = dateTime;
        cd.fcwExistFV = false;
        //cd.fcwTimeToCollision = 0;
        cd.fcwDistanceToFV = 0;
        cd.fcwRelativeSpeedToFV = 0;

        cd.fcwEvent = false;
        cd.fcwEventThreshold = 0;

        cd.ldwTimeStamp = dateTime;
        cd.ldwDistanceToLeftLane = 0;
        cd.ldwDistanceToRightLane = 0;
        cd.ldwEvent = 0;
        cd.mediaURI = currentFileName;

        return cd;
    }


}
