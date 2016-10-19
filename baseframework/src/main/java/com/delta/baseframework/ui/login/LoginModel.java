package com.delta.baseframework.ui.login;

import com.delta.baseframework.api.Api;
import com.delta.baseframework.data.entity._User;
import com.delta.baseframework.utils.RxsRxSchedulers;

import rx.Observable;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<_User.LoginResult> login(String name, String password) {


        //// TODO: 2016/10/19 如果先从本地读取在从网络获取怎么写
        _User user = new _User();
        user.setUsername(name);
        user.setPassword(password);

        return Api.getInstance().service.login(user).compose(RxsRxSchedulers.io_main());
    }


//    @Override
//    public void login(String username, String password) {
//        {
//            Map<String, String> param = new HashMap<>();
//            param.put("name", username);
//            param.put("pwd", password);
//            JSONObject object = new JSONObject(param);
//            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
//                    URl.LOGIN_URL, object, new Response.Listener<JSONObject>() {
//
//                @Override
//                public void onResponse(JSONObject response) {
//
//                    if (getListener() != null) {
//
//                        getListener().onSucess(response.toString());
//                    }
//                }
//            }, new Response.ErrorListener() {
//
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                    if (getListener() != null) {
//                        getListener().onFailed(null);
//                    }
//                }
//            }) {
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                    return super.getHeaders();
//                }
//            };
//
//            App.getQueue().add(request);
//
//        }
//    }
//
//    @Override
//    public void loginOut(String userName, String passWord) {
//
//
//
//    }

}


