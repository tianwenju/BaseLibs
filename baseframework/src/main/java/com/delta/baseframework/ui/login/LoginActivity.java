package com.delta.baseframework.ui.login;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.delta.baseframework.C;
import com.delta.baseframework.R;
import com.delta.baseframework.base.BaseActivity;
import com.delta.baseframework.data.entity._User;
import com.delta.baseframework.manager.RxManager;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Retrofit;
import rx.functions.Action1;

/**
 * Created by V.Wenju.Tian on 2016/10/19.
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> {

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


        btLogin = (Button) findViewById(R.id.bt_login);
        etName = ((EditText) findViewById(R.id.et_name));
        etPass = ((EditText) findViewById(R.id.et_pass));
        RxManager.getInstance().on(C.EVENT_LOGIN, new Action1<Object>() {


            @Override
            public void call(Object o) {
                Log.e(TAG, "call() called with: o = [" + o.toString() + "]");
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                _User user = new _User();
                user.setPassword("1qaz@WSX");
                user.setUsername("V.wenju.tian");

//                retrofit = new Retrofit.Builder()
//
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                        .baseUrl(Api.BASE_URL)
//                        .build();
//                ApiService apiService = retrofit.create(ApiService.class);



//               apiService.getSiteResults("drc","jan").compose(RxsRxSchedulers.io_main()).subscribe(new Subscriber<SiteData>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.e("自定义标签", "onCompleted: ");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                        Log.e("自定义标签", "onError: "+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(SiteData s) {
//
//                        Log.e("自定义标签", "onNext: "+s.toString());
//                    }
//                });
//                Api.getInstance().service.login(user).compose(RxsRxSchedulers.io_main()).subscribe(new Subscriber<_User.LoginResult>() {
//                    @Override
//                    public void onCompleted() {
//
//                        Log.e("自定义标签", "onCompleted: ");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                        Log.e("自定义标签", "onError: "+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(_User.LoginResult loginResult) {
//
//                        Log.e("自定义标签", "onNext: "+loginResult.toString());
//                    }
//                });

//                Log.e("自定义标签", "onClick: ");
//                if (TextUtils.isEmpty(etName.getText()) || TextUtils.isEmpty(etPass.getText())) {
//                    return;
//                }
//
//
                mPresenter.Login("V.wenju.tian", "1qaz@WSX");

            }
        });
    }

    @Override
    public void showSucess() {

        Log.e("自定义标签", "showSucess: ");
    }

    @Override
    public void showError() {

        Log.e("自定义标签", "showError: ");
    }

    @OnClick(R.id.bt_login)
    public void onClick() {
        Log.e("自定义标签", "onClick: ");
        if (TextUtils.isEmpty(etName.getText()) || TextUtils.isEmpty(etPass.getText())) {
            return;
        }

        mPresenter.Login(etName.getText().toString(), etPass.getText().toString());

    }
}
