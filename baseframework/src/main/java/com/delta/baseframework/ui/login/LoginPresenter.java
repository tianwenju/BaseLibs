package com.delta.baseframework.ui.login;

import android.util.Log;

import com.delta.baseframework.C;
import com.delta.baseframework.data.entity._User;

import rx.functions.Action1;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class LoginPresenter extends LoginContract.Presenter<LoginModel> {


    @Override
    void Login(String userName, String passWord) {
        /**
         * 在Presenter里确定订阅关系
         */
        getRxManager().add(getModel().login(userName, passWord).subscribe(new Action1<_User.LoginResult>() {
            @Override
            public void call(_User.LoginResult loginResult) {
                getRxManager().post(C.EVENT_LOGIN, loginResult);

                getView().loginSucess();
                Log.e("自定义标签", "call: " + loginResult.toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e(TAG, "call() called with: throwable = [" + throwable + "]");
            }
        }));


    }
}
