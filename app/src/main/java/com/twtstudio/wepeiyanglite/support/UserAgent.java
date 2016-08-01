package com.twtstudio.wepeiyanglite.support;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.twtstudio.wepeiyanglite.WePeiYangApp;

/**
 * Created by sunjuntao on 16/1/10.
 */
public class UserAgent {
    // FIXME
    public static String getAppVersion() {
        PackageManager packageManager = WePeiYangApp.getContext().getPackageManager();
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(WePeiYangApp.getContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = "";
        if (packInfo != null) {
            version = packInfo.versionName;
        }
        return version;
    }

    public static String getPhoneName() {
        return Build.MODEL;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getCPU() {
        return Build.CPU_ABI;
    }

    public static String getDisplay() {
        return Build.DISPLAY;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String generate() {
        return  "WePeiYang/" + getAppVersion() + "(" + getBrand() + " " + getPhoneName() + ";" + "android " + getSystemVersion() + ";" + "cpu " + getCPU() + ";" + "rom " + getDisplay() + ")";
    }
}
