package com.delta.baseframework.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.delta.baseframework.utils.TUtil;
import com.delta.baseframework.utils.TUtils;

import butterknife.ButterKnife;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public abstract class BaseActivity<T extends BasePersenter, V extends IModel> extends AppCompatActivity implements IView {
    protected T mPresenter;
    protected V mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof IView) {
            mPresenter.set(this, mModel);
        } if (this instanceof IView) {
            mPresenter.set(this, mModel);
        }
        initView();

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


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
