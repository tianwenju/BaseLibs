package com.delta.baseframework.base;

import com.delta.baseframework.manager.RxManager;

/**
 * Created by V.Wenju.Tian on 2016/9/1.
 */
public abstract class BasePersenter<T, V > {

    protected T mIModel;
    protected V mIView;
    protected RxManager rxManager = new RxManager();

    public RxManager getRxManager() {
        return rxManager;
    }

    public void set(V mIView, T mIModel) {
        this.mIView = mIView;
        this.mIModel = mIModel;
        onStart();
    }

    protected abstract void onStart();

    void onDestory() {
        mIView = null;
        rxManager.clear();
    }

}
