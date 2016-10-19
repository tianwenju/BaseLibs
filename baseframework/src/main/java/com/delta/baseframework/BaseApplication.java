package com.delta.baseframework;

import android.app.Application;
import android.os.Handler;


/**
 * Created by Administrator on 2016/7/3.
 */
public class BaseApplication extends Application {

    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mainTid = android.os.Process.myTid();
        handler = new Handler();
    }

    public static BaseApplication getApplication() {
        return application;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }

}
