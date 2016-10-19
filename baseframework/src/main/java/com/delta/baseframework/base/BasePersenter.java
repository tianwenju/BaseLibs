package com.delta.baseframework.base;

import com.delta.baseframework.manager.RxManager;

/**
 * Created by V.Wenju.Tian on 2016/9/1.
 */
public abstract class BasePersenter<T extends IModel, V extends IView> {

    protected T mIModel;
    protected V mIView;
    protected RxManager rxManager = RxManager.getInstance();


    void set(V mIView, T mIModel) {
        this.mIModel = mIModel;
        this.mIView = mIView;
        onStart();
    }

    protected abstract void onStart();

    void onDestory() {
        mIView = null;
    }

}
