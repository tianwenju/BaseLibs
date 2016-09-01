package com.qf.baseframework;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/16.
 */
public abstract  class BaseActivity extends AppCompatActivity {

    public static List<BaseActivity> mActivities = new LinkedList<>();
    public static BaseActivity activity;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        synchronized (mActivities) {
            mActivities.add(this);
        }
        init();
        initView();
        initActionBar();

    }

    public void killAll() {
        List<BaseActivity> datas ;
        synchronized (mActivities){
        datas= new LinkedList<>(mActivities);
        }
        for (BaseActivity data : datas) {
            data.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    /**
     * 初始化数据
     */
    protected abstract void init();

    /**
     * 初始化视图
     */
    protected  abstract  void initView();

    /**
     * 初始化actionBar
     */
    protected abstract void initActionBar();

    @Override
    protected void onResume() {
        super.onResume();
        activity=this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity=null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities){
        mActivities.remove(this);
        }
    }
}
