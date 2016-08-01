package com.twtstudio.wepeiyanglite.router.interceptors;

import android.text.TextUtils;

import com.twtstudio.wepeiyanglite.router.base.RouterInterceptor;
import com.twtstudio.wepeiyanglite.support.PrefUtils;

/**
 * Created by huangyong on 16/5/18.
 */
public class AuthInterceptor implements RouterInterceptor {

    public static final String NAME = "auth";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean intercept(String url) {
        String token = PrefUtils.getToken();
        return !TextUtils.isEmpty(token);
    }

}
