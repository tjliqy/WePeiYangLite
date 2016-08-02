package com.twtstudio.wepeiyanglite;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.twtstudio.wepeiyanglite.router.RouterSchema;
import com.twtstudio.wepeiyanglite.router.WePeiYangRouter;
import com.twtstudio.wepeiyanglite.router.base.IWePeiYangRouteTableInitializer;
import com.twtstudio.wepeiyanglite.router.interceptors.AuthInterceptor;
import com.twtstudio.wepeiyanglite.ui.auth.AuthActivity;

import java.util.Map;

import cn.campusapp.router.Router;
import cn.campusapp.router.router.IActivityRouteTableInitializer;

/**
 * Created by jcy on 2016/7/31.
 */

public class WePeiYangApp extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=getApplicationContext();
        //initRouter();
        //testInit();
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

                map.put(RouterSchema.AUTH, AuthActivity.class);
            }
        });
        router.addInterceptor(new AuthInterceptor());
        Router.addRouter(router);
        Router.setDebugMode(true);

    }

    private void testInit()
    {
        Router.initActivityRouter(sContext, new IActivityRouteTableInitializer() {
            @Override
            public void initRouterTable(Map<String, Class<? extends Activity>> map) {
                map.put(RouterSchema.AUTH,AuthActivity.class);
            }
        });
        Router.setDebugMode(true);
    }

}
