package com.delta.baseframework.modify;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.delta.baseframework.base.IView;
import com.delta.baseframework.utils.TUtil;
import com.wenju.statusbar.StatusBarCompat;

import butterknife.ButterKnife;
import butterknife.Unbinder;

;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public abstract class MBaseActivity<T extends MBasePresenter> extends AppCompatActivity{
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        Unbinder bind = ButterKnife.bind(this);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor("#ff00ff"));
        mPresenter = TUtil.getT(this, 0);
        Log.e("自定义标签", "onCreate: ");
        if (this instanceof IView) {
            Log.e("自定义标签", "onCreate: "+"------------");
            mPresenter.set(this);
        }
        initView();

    }

    public T getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.onDestory();
        }
    }

    protected abstract int getLayoutID();

    //初始化操作protected
    protected abstract void initView();
}
