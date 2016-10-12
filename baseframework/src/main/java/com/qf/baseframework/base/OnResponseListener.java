package com.qf.baseframework.base;

import android.support.annotation.Nullable;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public interface OnResponseListener<T, E> {

    void onSucess(T t);

    void onFailed(@ Nullable  E e);
}
