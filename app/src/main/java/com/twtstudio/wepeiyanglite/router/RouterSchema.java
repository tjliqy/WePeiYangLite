package com.twtstudio.wepeiyanglite.router;

/**
 * Created by huangyong on 16/5/18.
 */
public class RouterSchema {

    public static final String SCHEMA = "wepeiyang";

    public static final String SCHEMA_PREFIX = SCHEMA + "://";

    public static final String AUTH = SCHEMA_PREFIX + "auth/:s{type}";

    public static String authBuilder(String type) {
        return SCHEMA_PREFIX + "auth/" + type;
    }

    public static final String HOME = SCHEMA_PREFIX + "home";

    public static final String GPA = SCHEMA_PREFIX + "apps/gpa";

}
