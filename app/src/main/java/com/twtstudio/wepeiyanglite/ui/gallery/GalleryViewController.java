package com.twtstudio.wepeiyanglite.ui.gallery;

import com.twtstudio.wepeiyanglite.common.IViewController;
import com.twtstudio.wepeiyanglite.model.GalleryIndexItem;

import java.util.List;

/**
 * Created by jcy on 2016/8/3.
 */

public interface GalleryViewController extends IViewController {
    void refreshItems(List<GalleryIndexItem> items);
}
