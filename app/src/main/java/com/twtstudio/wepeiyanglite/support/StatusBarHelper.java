package com.twtstudio.wepeiyanglite.support;

import android.app.Activity;
import android.os.Build;

import com.readystatesoftware.systembartint.SystemBarTintManager;


/**
 * Created by Rex on 2015/8/1.
 */
public class StatusBarHelper {
    private static com.readystatesoftware.systembartint.SystemBarTintManager tintManager;

    public static void setColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(color);
        }
    }
}
