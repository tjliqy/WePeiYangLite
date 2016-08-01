package com.twtstudio.wepeiyanglite.ui.auth;

import com.twtstudio.wepeiyanglite.common.IViewController;

/**
 * Created by huangyong on 16/5/18.
 */
public interface AuthViewController extends IViewController {
    void showUsernameError(String message);
    void showPasswordError(String message);
}
