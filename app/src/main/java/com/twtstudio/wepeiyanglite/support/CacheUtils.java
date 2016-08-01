package com.twtstudio.wepeiyanglite.support;

import com.twtstudio.wepeiyanglite.WePeiYangApp;

/**
 * Created by sunjuntao on 16/1/27.
 */
public class CacheUtils {
    public static void clear() {
        ACache cache = ACache.get(WePeiYangApp.getContext());
        cache.remove("gpa");
        cache.remove("classtable");
    }
}
