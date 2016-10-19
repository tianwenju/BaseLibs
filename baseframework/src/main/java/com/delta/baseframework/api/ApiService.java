package com.delta.baseframework.api;


import com.delta.baseframework.data.entity.SiteData;
import com.delta.baseframework.data.entity._User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/3/23.
 */
public interface ApiService {
    @POST("library/user/login2")
    Observable<_User.LoginResult> login(@Body _User user);

    @POST("/WebAPI/API/SiteSearch")
    Call<SiteData> getSiteResults(@Header("LoginID") String id, @Header("SiteName") String siteName);


}
