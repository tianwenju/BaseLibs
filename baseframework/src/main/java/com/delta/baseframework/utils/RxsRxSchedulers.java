package com.delta.baseframework.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by V.Wenju.Tian on 2016/10/18.
 */

public class RxsRxSchedulers {
    public static <T> Observable.Transformer<T, T> io_main() {

        return tObservable -> tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                ;
    }
}
