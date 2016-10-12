package com.qf.baseframework.login;

import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.qf.baseframework.App;
import com.qf.baseframework.URl;
import com.qf.baseframework.base.BaseModel;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by V.Wenju.Tian on 2016/9/2.
 */
public class LoginModel extends BaseModel<String, Nullable> implements LoginContract.Model {


    @Override
    public void login(String username, String password) {
        {
            Map<String, String> param = new HashMap<>();
            param.put("name", username);
            param.put("pwd", password);
            JSONObject object = new JSONObject(param);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                    URl.LOGIN_URL, object, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {

                    if (getListener() != null) {

                        getListener().onSucess(response.toString());
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    if (getListener() != null) {
                        getListener().onFailed(null);
                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return super.getHeaders();
                }
            };

            App.getQueue().add(request);

        }
    }

    @Override
    public void loginOut(String userName, String passWord) {



    }

}


