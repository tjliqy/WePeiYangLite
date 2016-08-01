package com.twtstudio.wepeiyanglite.ui.auth;

import android.content.Context;
import android.text.TextUtils;

import com.twtstudio.wepeiyanglite.R;
import com.twtstudio.wepeiyanglite.api.ApiSubscriber;
import com.twtstudio.wepeiyanglite.api.OnNextListener;
import com.twtstudio.wepeiyanglite.api.WePeiYangClient;
import com.twtstudio.wepeiyanglite.common.Presenter;
import com.twtstudio.wepeiyanglite.model.Token;
import com.twtstudio.wepeiyanglite.support.PrefUtils;
import com.twtstudio.wepeiyanglite.support.ResourceHelper;

/**
 * Created by huangyong on 16/5/18.
 */
public class AuthPresenter extends Presenter {

    protected AuthViewController mViewController;

    public AuthPresenter(Context context, AuthViewController controller) {
        super(context);
        mViewController = controller;
    }

    public boolean validate(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            mViewController.showUsernameError(ResourceHelper.getString(R.string.empty_error));
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            mViewController.showPasswordError(ResourceHelper.getString(R.string.empty_error));
            return false;
        }
        return true;
    }

    public void submit(String username, String password) {
        String type = ((AuthActivity) mContext).getType();
        if (AuthActivity.AUTH_TWT.equals(type)) {
            login(username, password);
        } else if (AuthActivity.AUTH_TJU.equals(type)) {
            // TODO
        } else if (AuthActivity.ATUH_LIB.equals(type)) {
            // TODO
        }
    }

    protected void login(String username, String password) {
        WePeiYangClient.getInstance().login(mContext, new ApiSubscriber<>(mContext, mOnTokenListener), username, password);
    }

    protected OnNextListener<Token> mOnTokenListener = new OnNextListener<Token>() {
        @Override
        public void onNext(Token token) {
            PrefUtils.setToken(token.token);
            mViewController.toastMessage("token ok");
        }
    };
}
