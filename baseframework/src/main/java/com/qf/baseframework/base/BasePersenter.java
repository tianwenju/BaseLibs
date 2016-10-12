package com.qf.baseframework.base;

/**
 * Created by V.Wenju.Tian on 2016/9/1.
 */
public abstract class BasePersenter<T extends IModel, V extends IView> {

    private T mIModel;
    private V mIView;


    void set(V mIView, T mIModel) {
        this.mIModel = mIModel;
        this.mIView = mIView;
        if (mIModel instanceof BaseModel) {

        }
        onStart();
    }

    protected abstract void onStart();

    void onDestory() {
        mIView = null;
    }

}
