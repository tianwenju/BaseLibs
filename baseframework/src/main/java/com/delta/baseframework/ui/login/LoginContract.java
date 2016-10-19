package com.delta.baseframework.ui.login;

import com.delta.baseframework.base.BasePersenter;
import com.delta.baseframework.base.IModel;
import com.delta.baseframework.base.IView;
import com.delta.baseframework.data.entity._User;

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

        void loginFailed();
    }

    abstract class Presenter extends BasePersenter<Model, View> {

        abstract void Login(String userName, String passWord);

        abstract void loginOut(String userName, String passWord);

        @Override
        protected void onStart() {

        }
    }


}
