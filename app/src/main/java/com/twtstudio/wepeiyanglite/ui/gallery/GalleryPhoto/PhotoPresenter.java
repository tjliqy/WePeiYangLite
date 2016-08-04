package com.twtstudio.wepeiyanglite.ui.gallery.GalleryPhoto;

import android.content.Context;

import com.twtstudio.wepeiyanglite.api.ApiSubscriber;
import com.twtstudio.wepeiyanglite.api.OnNextListener;
import com.twtstudio.wepeiyanglite.api.WePeiYangClient;
import com.twtstudio.wepeiyanglite.common.Presenter;
import com.twtstudio.wepeiyanglite.model.GalleryPhotos;

import java.util.List;

/**
 * Created by jcy on 2016/8/3.
 */

public class PhotoPresenter extends Presenter {
    private PhotoViewController mViewController;

    public PhotoPresenter(Context context, PhotoViewController viewController) {
        super(context);
        mViewController = viewController;
    }

    public void getPhotos(int id) {
        WePeiYangClient.getInstance().getGalleryPhotos(mContext, new ApiSubscriber(mContext, mListener), id);
    }

    private OnNextListener<List<GalleryPhotos>> mListener = new OnNextListener<List<GalleryPhotos>>() {
        @Override
        public void onNext(List<GalleryPhotos> photosList) {
            mViewController.refreshItems(photosList);
        }
    };
}
