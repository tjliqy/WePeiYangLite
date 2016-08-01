package com.twtstudio.wepeiyanglite;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.twtstudio.wepeiyanglite.router.WePeiYangRouter;
import com.twtstudio.wepeiyanglite.router.base.IWePeiYangRouteTableInitializer;

import java.util.Map;

/**
 * Created by jcy on 2016/7/31.
 */

public class WePeiYangApp extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=getApplicationContext();
        initRouter();
    }

    public static Context getContext() {
        return sContext;
    }

    private void initRouter(){
        WePeiYangRouter router = new WePeiYangRouter(getApplicationContext(), new IWePeiYangRouteTableInitializer() {
            @Override
            public void initInterceptorTable(Map<String, String> interceptorTable) {
                //TODO: 不知道
            }

            @Override
            public void initRouterTable(Map<String, Class<? extends Activity>> map) {
                //TODO: 添加activity的路由表
            }
        });
    }

}
