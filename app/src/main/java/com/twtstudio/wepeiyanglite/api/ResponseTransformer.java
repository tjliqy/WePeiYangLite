package com.twtstudio.wepeiyanglite.api;

import android.util.Log;

import rx.functions.Func1;

/**
 * Created by huangyong on 16/5/19.
 */
public class ResponseTransformer<T> implements Func1<ApiResponse<T>, T> {
    String TAG = "transformer";
    @Override
    public T call(ApiResponse<T> tAPIResponse) {
        if (tAPIResponse.getErrorCode() != -1) {
            throw new ApiException(tAPIResponse);
        }
        Log.d(TAG, "call: "+tAPIResponse.getData().toString());
        return tAPIResponse.getData();
    }
}
