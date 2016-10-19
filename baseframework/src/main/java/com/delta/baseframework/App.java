package com.delta.baseframework;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.delta.baseframework.utils.SpUtil;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class App extends Application {

    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        SpUtil.init(this);
    }

    public static Context getAppContext() {
        return mApp;
    }

    public static Resources getAppResources() {
        return mApp.getResources();
    }
//    public static Context mContext;
//
//    public static RequestQueue mQueue;
//
//    public static Context getContext() {
//        return mContext;
//    }
//
//    public static void setmContext(Context mContext) {
//        App.mContext = mContext;
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        // HTTPSTrustManager.allowAllSSL ();FIXME 確定合適允許HTTPS請求
//        mQueue = Volley.newRequestQueue(getApplicationContext());
//
//    }
//
//    public static RequestQueue getQueue() {
//        return mQueue;
//    }
//
//    public <T> void addToRequestQueue(Request<T> req) {
//        getQueue().add(req);
//    }
//
//    public static void stopOne(Object object) {
//        getQueue().cancelAll(object);
//    }

}

