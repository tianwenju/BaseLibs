package com.qf.baseframework;

import android.widget.FrameLayout;

public class MainActivity extends BaseActivity {


    private FrameLayout container;

    @Override
    protected void init() {


        container = (FrameLayout) findViewById(R.id.container);


    }

    @Override
    protected void initView() {

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initActionBar() {

    }

}
