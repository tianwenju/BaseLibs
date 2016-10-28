package com.delta.baseframework.ui.login;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.delta.baseframework.C;
import com.delta.baseframework.R;
import com.delta.baseframework.modify.MBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Retrofit;
import rx.functions.Action1;

/**
 * Created by V.Wenju.Tian on 2016/10/19.
 */

public class LoginActivity extends MBaseActivity<LoginPresenter> implements LoginContract.View {
    @Override
    public void loginSucess() {

    }

    @Override
    public void loginFailed() {

    }
    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.bt_login)
    Button btLogin;
    private Retrofit retrofit;

    @Override
    protected void onStart() {
        Log.e("自定义标签", "onStart: ");
        super.onStart();
    }

    @Override
    protected int getLayoutID() {
        Log.e("自定义标签", "getLayoutID: ");
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


//        btLogin = (Button) findViewById(R.id.bt_login);
//        etName = ((EditText) findViewById(R.id.et_name));
//        etPass = ((EditText) findViewById(R.id.et_pass));
        getPresenter().getRxManager().on(C.EVENT_LOGIN, new Action1<Object>() {

            @Override
            public void call(Object o) {

                Log.e(TAG, "call() called with: o = [" + o.toString() + "]"+o.getClass());
            }
        });

    }


    @OnClick(R.id.bt_login)
    public void onClick() {
        Log.e("自定义标签", "onClick: ");
        getPresenter().Login("V.wenju.tian", "1qaz@WSX");

    }
}
