package com.qf.baseframework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.baseframework.base.IView;
import com.qf.baseframework.utils.ViewUtils;
import com.qf.baseframework.view.LoadingPage;


public abstract class IFragment extends Fragment implements IView {

    private LoadingPage loadingPage;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        if (loadingPage == null) {  // 之前的frameLayout 已经记录了一个爹了  爹是之前的ViewPager
            loadingPage = new LoadingPage(getActivity()) {
                @Override
                protected void OnErrorClick(View mV) {

                }

                @Override
                public View createSuccessView() {
                    return inflater.inflate(getSucessViewId(), container, false);
                }

            };
        } else {
            ViewUtils.removeParent(loadingPage);// 移除frameLayout之前的爹
        }
        initView();
        return loadingPage;  //  拿到当前viewPager 添加这个framelayout
    }

    protected abstract void initView();


    protected abstract void initData();

    protected abstract int getSucessViewId();


    @Override
    public void onResume() {

        super.onResume();
    }

    /***
     * 创建成功的界面
     *
     * @return
     */
    public abstract View createSuccessView();

    /**
     * 请求服务器
     *
     * @return
     */
    @Override
    public void showSucess() {
        if(loadingPage!=null){
            loadingPage.showPage(LoadingPage.STATE_SUCCESS);
        }
    }

    @Override
    public void showError() {
        if(loadingPage!=null){
            loadingPage.showPage(LoadingPage.STATE_ERROR);
        }
    }
}
