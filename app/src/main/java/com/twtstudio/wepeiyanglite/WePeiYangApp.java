package com.twtstudio.wepeiyanglite;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.florent37.glidepalette.GlidePalette;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.twtstudio.wepeiyanglite.router.RouterSchema;
import com.twtstudio.wepeiyanglite.router.WePeiYangRouter;
import com.twtstudio.wepeiyanglite.router.base.IWePeiYangRouteTableInitializer;
import com.twtstudio.wepeiyanglite.router.interceptors.AuthInterceptor;
import com.twtstudio.wepeiyanglite.ui.auth.AuthActivity;
import com.twtstudio.wepeiyanglite.ui.main.MainActivity;

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
        initRouter();
        //testInit();
        initDrawerImageLoader();
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
                map.put(RouterSchema.MAIN, MainActivity.class);
            }
        });
        router.addInterceptor(new AuthInterceptor());
        Router.addRouter(router);
        Router.setDebugMode(true);

    }

    //init the ImageLoader of Material-Drawer
    private void initDrawerImageLoader()
    {
        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public Drawable placeholder(Context ctx, String tag) {
                //占位符暂不处理
                return super.placeholder(ctx, tag);
            }

            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                Glide.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
            }

            @Override
            public void cancel(ImageView imageView) {
                Glide.clear(imageView);}
        });
    }
}
