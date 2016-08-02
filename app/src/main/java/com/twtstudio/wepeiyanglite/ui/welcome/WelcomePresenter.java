package com.twtstudio.wepeiyanglite.ui.welcome;

import android.content.Context;

import com.twtstudio.wepeiyanglite.common.Presenter;
import com.twtstudio.wepeiyanglite.support.CacheLogoTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jcy on 2016/8/1.
 */

public class WelcomePresenter extends Presenter {

    private WelcomeViewController mWelcomeViewController;

    public WelcomePresenter(Context context, WelcomeViewController controller) {
        super(context);
        mWelcomeViewController = controller;
    }

    public void cacheLogo(){
        CacheLogoTask cacheLogoTask = new CacheLogoTask(mContext);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(cacheLogoTask);
        executor.shutdown();
        // TODO: 2016/8/1 缓存logo处理不当
        mWelcomeViewController.setCacheLogoStatue(true);
    }

}
