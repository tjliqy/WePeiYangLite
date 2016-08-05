package com.twtstudio.wepeiyanglite.ui.studyRoom.detail;

import android.content.Context;

import com.twtstudio.wepeiyanglite.api.ApiSubscriber;
import com.twtstudio.wepeiyanglite.api.OnNextListener;
import com.twtstudio.wepeiyanglite.api.WePeiYangClient;
import com.twtstudio.wepeiyanglite.common.Presenter;
import com.twtstudio.wepeiyanglite.model.AvailableRoom;

import java.util.List;

/**
 * Created by jcy on 2016/8/4.
 */

public class DetailPresenter extends Presenter {
    private DetailViewController mViewController;

    public DetailPresenter(Context context, DetailViewController viewController) {
        super(context);
        mViewController = viewController;
    }

    public void refreshItems(int bid, String time) {
        WePeiYangClient.getInstance().getAvailableRooms(mContext, new ApiSubscriber(mContext, mListener), bid, time);
    }

    private OnNextListener<List<String>> mListener = new OnNextListener<List<String>>() {
        @Override
        public void onNext(List<String> availableRooms) {
            mViewController.refreshItems(availableRooms);
        }
    };
}
