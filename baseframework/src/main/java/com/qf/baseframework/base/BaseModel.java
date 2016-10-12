package com.qf.baseframework.base;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public abstract class BaseModel<T,   E> {

    private OnResponseListener<T, E> listener;

    public void setListener(OnResponseListener<T, E> mListener) {
        listener = mListener;
    }
    public OnResponseListener<T, E> getListener() {
        return listener;
    }
}
