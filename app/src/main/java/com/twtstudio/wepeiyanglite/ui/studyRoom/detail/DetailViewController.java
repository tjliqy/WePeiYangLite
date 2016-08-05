package com.twtstudio.wepeiyanglite.ui.studyRoom.detail;

import com.twtstudio.wepeiyanglite.common.IViewController;
import com.twtstudio.wepeiyanglite.model.AvailableRoom;

import java.util.List;

/**
 * Created by jcy on 2016/8/4.
 */

public interface DetailViewController extends IViewController {
    void refreshItems(List<String> availableRoomList);
}
