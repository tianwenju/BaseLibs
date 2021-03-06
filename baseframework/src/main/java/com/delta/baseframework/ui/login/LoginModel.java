package com.delta.baseframework.ui.login;

import android.util.Log;

import com.delta.baseframework.api.Api;
import com.delta.baseframework.data.entity._User;
import com.delta.baseframework.utils.RxsRxSchedulers;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<_User.LoginResult> login(String name, String password) {


        _User user = new _User();
        user.setUsername(name);
        user.setPassword(password);
        //// TODO: 2016/10/19 如果先从本地读取在从网络获取怎么写
        Observable<_User.LoginResult> observable = Observable.create(new Observable.OnSubscribe<_User.LoginResult>() {
            @Override
            public void call(Subscriber<? super _User.LoginResult> subscriber) {
                _User.LoginResult loginResult = new _User.LoginResult();
                Log.d(TAG, "call() called with: subscriber = [" + subscriber + "]");
                if (loginResult != null) {

                    subscriber.onNext(loginResult);
                } else {

                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());


        return Api.getInstance().service.login(user).compose(RxsRxSchedulers.io_main());
    }
}


