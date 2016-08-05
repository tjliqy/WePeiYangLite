package com.twtstudio.wepeiyanglite.ui.gallery.GalleryPhoto;

import com.twtstudio.wepeiyanglite.common.IViewController;
import com.twtstudio.wepeiyanglite.model.GalleryPhotos;

import java.util.List;

/**
 * Created by jcy on 2016/8/3.
 */

public interface PhotoViewController extends IViewController {
    void refreshItems(List<GalleryPhotos> photosList);
}
