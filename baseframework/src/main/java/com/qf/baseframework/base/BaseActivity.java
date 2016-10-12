package com.qf.baseframework.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.qf.baseframework.utils.TUtil;
import com.qf.baseframework.utils.TUtils;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public abstract class BaseActivity<T extends BasePersenter, V extends IModel> extends AppCompatActivity implements IView {
    private T mPresenter;
    private V mModel;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutID());
        //初始化操作
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof IView) {
            mPresenter.set(this, mModel);
        }

    }

    protected abstract int getLayoutID();
}
