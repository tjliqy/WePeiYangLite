package com.twtstudio.wepeiyanglite.ui.studyRoom;

import com.twtstudio.wepeiyanglite.model.SchoolBuildings;

import java.util.List;

/**
 * Created by jcy on 2016/8/4.
 */

public interface StudyRoomViewController {
    void refreshItems(List<SchoolBuildings.BuildingsBean> beanList);
    void setWeekNumber(String s);
}
