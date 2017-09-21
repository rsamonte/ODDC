package com.neusoft.oddc;

import android.support.multidex.MultiDexApplication;

import com.neusoft.oddc.db.gen.DaoMaster;
import com.neusoft.oddc.db.gen.DaoSession;

import org.greenrobot.greendao.database.Database;


public class MyApplication extends MultiDexApplication {

    private static final String TAG = MyApplication.class.getSimpleName();

    private DaoSession daoSession;

    public static boolean ADAS_OK = false;

    @Override
    public void onCreate() {
        super.onCreate();

        initDataBase();

    }

    private void initDataBase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
