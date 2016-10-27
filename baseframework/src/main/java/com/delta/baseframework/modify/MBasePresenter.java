package com.delta.baseframework.modify;

import android.util.Log;

import com.delta.baseframework.manager.RxManager;
import com.delta.baseframework.utils.TUtil;

/**
 * Created by V.Wenju.Tian on 2016/10/26.
 */

public  abstract  class MBasePresenter<T,V> {

    protected T mIModel;
    protected V mIView;
    protected RxManager rxManager = new RxManager();

    public RxManager getRxManager() {
        return rxManager;
    }


    public T getModel() {
        return mIModel;
    }

    public V getView() {
        return mIView;
    }

    public void set(V mIView) {
        this.mIView = mIView;
        this.mIModel = TUtil.getT(this,0);
        Log.e("自定义标签", "set: "+mIView.getClass().getName()+mIModel.getClass().getName());
        onStart();
    }
    protected abstract void onStart();

   public void onDestory() {
        mIView = null;
        rxManager.clear();
    }
}
