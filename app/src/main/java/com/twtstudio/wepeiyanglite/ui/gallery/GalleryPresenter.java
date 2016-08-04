package com.twtstudio.wepeiyanglite.ui.gallery;

import android.content.Context;
import android.util.Log;

import com.twtstudio.wepeiyanglite.WePeiYangApp;
import com.twtstudio.wepeiyanglite.api.ApiSubscriber;
import com.twtstudio.wepeiyanglite.api.OnNextListener;
import com.twtstudio.wepeiyanglite.api.WePeiYangClient;
import com.twtstudio.wepeiyanglite.common.Presenter;
import com.twtstudio.wepeiyanglite.model.GalleryIndexItem;

import java.util.List;

/**
 * Created by jcy on 2016/8/3.
 */

public class GalleryPresenter extends Presenter {
    private GalleryViewController mViewController;

    public GalleryPresenter(Context context, GalleryViewController viewController) {
        super(context);
        mViewController = viewController;
    }

    public void getGallery() {
        WePeiYangClient.getInstance().getGalleryIndex(mContext, new ApiSubscriber(mContext, mListener));
    }

    private OnNextListener<List<GalleryIndexItem>> mListener = new OnNextListener<List<GalleryIndexItem>>() {
        @Override
        public void onNext(List<GalleryIndexItem> indexItems) {
            mViewController.refreshItems(indexItems);
        }
    };
}
