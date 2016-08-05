package com.twtstudio.wepeiyanglite.ui.studyRoom;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.twtstudio.wepeiyanglite.R;
import com.twtstudio.wepeiyanglite.common.ui.BaseAdapter;
import com.twtstudio.wepeiyanglite.common.ui.BaseViewHolder;
import com.twtstudio.wepeiyanglite.model.SchoolBuildings;
import com.twtstudio.wepeiyanglite.router.RouterSchema;

import butterknife.BindView;
import cn.campusapp.router.Router;

/**
 * Created by jcy on 2016/8/4.
 */

public class StudyBuildingsAdapter extends BaseAdapter<SchoolBuildings.BuildingsBean> {

    private static final int ITEM_NORMAL = 0;
    private static final int ITEM_FOOTER = 1;

    public StudyBuildingsAdapter(Context context) {
        super(context);
    }

    static class sBuildingHolder extends BaseViewHolder {
        @BindView(R.id.school_build_number)
        TextView mBuildingNameView;
        @BindView(R.id.school_build_card)
        CardView mCardView;

        public sBuildingHolder(View itemView) {
            super(itemView);
        }
    }

    static class FooterHolder extends BaseViewHolder {

        @BindView(R.id.pb_footer)
        ProgressBar mFooter;

        public FooterHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (viewType == ITEM_FOOTER) {
            return new FooterHolder(inflater.inflate(R.layout.footer, parent, false));
        } else {
            return new sBuildingHolder(inflater.inflate(R.layout.item_school_building, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ITEM_NORMAL) {
            sBuildingHolder itemHolder = (sBuildingHolder) holder;
            final SchoolBuildings.BuildingsBean item = mDataSet.get(position);
            itemHolder.mBuildingNameView.setText(item.name + "楼");
            itemHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Router.open(RouterSchema.CLASSROOM_PREFIX+"/"+item.id+"/"+item.name);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mDataSet.size()) {
            return ITEM_FOOTER;
        } else {
            return ITEM_NORMAL;
        }
    }
}
