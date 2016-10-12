package com.qf.baseframework.login;

import com.qf.baseframework.base.IModel;
import com.qf.baseframework.base.BasePersenter;
import com.qf.baseframework.base.IView;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public interface LoginContract {

    interface Model extends IModel {

        void login(String userName, String passWord);

        void loginOut(String userName, String passWord);
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
