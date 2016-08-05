package com.twtstudio.wepeiyanglite.ui.studyRoom;

import android.content.Context;

import com.twtstudio.wepeiyanglite.api.ApiSubscriber;
import com.twtstudio.wepeiyanglite.api.OnNextListener;
import com.twtstudio.wepeiyanglite.api.WePeiYangClient;
import com.twtstudio.wepeiyanglite.common.Presenter;
import com.twtstudio.wepeiyanglite.model.SchoolBuildings;

/**
 * Created by jcy on 2016/8/4.
 */

public class StudyRoomPresenter extends Presenter {
    private StudyRoomViewController mViewController;

    public StudyRoomPresenter(Context context, StudyRoomViewController viewController) {
        super(context);
        mViewController = viewController;
    }

    public void getBuildings(){
        WePeiYangClient.getInstance().getBuildingsId(mContext,new ApiSubscriber(mContext,mListener));
    }

    private OnNextListener<SchoolBuildings> mListener=new OnNextListener<SchoolBuildings>() {
        @Override
        public void onNext(SchoolBuildings buildings) {
            mViewController.refreshItems(buildings.buildings);
            mViewController.setWeekNumber(String.valueOf(buildings.current_week));
        }
    };
}
