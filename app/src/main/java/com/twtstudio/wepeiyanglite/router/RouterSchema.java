package com.twtstudio.wepeiyanglite.router;

/**
 * Created by huangyong on 16/5/18.
 */
public class RouterSchema {

    public static final String SCHEMA = "activity";

    public static final String SCHEMA_PREFIX = SCHEMA + "://";

    public static final String AUTH_PREFIX = SCHEMA_PREFIX + "auth";

    public static final String AUTH = AUTH_PREFIX+ "/:s{type}";

    public static final String MAIN_PREFIX = SCHEMA_PREFIX + "main";

    public static final String MAIN = MAIN_PREFIX;

    public static String urlBuilder(String prefix, String ...args) {
        for(String arg : args){
            prefix += "/" + arg;
        }
        return prefix;
    }

    public static final String HOME = SCHEMA_PREFIX + "home";

    public static final String GPA = SCHEMA_PREFIX + "apps/gpa";

}
