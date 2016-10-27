package com.delta.baseframework.ui.login;


import com.delta.baseframework.base.IModel;
import com.delta.baseframework.base.IView;
import com.delta.baseframework.data.entity._User;
import com.delta.baseframework.modify.MBasePresenter;

import rx.Observable;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public interface LoginContract {

    interface Model extends IModel {

        Observable<_User.LoginResult> login(String name,String password);

    }

    interface View extends IView {

        void loginSucess();

    }

    abstract class Presenter<T> extends MBasePresenter<T, View> {

        abstract void Login(String userName, String passWord);



        @Override
        protected void onStart() {

        }
    }


}
