package com.twtstudio.wepeiyanglite.ui.studyRoom.detail;

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
import com.twtstudio.wepeiyanglite.model.AvailableRoom;
import com.twtstudio.wepeiyanglite.router.RouterSchema;

import butterknife.BindView;
import cn.campusapp.router.Router;

/**
 * Created by jcy on 2016/8/4.
 */

public class DetailAdapter extends BaseAdapter<String> {
    private static final int ITEM_NORMAL = 0;
    private static final int ITEM_FOOTER = 1;

    public DetailAdapter(Context context) {
        super(context);
    }

    static class sRoomInfoHolder extends BaseViewHolder {
        @BindView(R.id.room_number)
        TextView mRoomNumber;

        public sRoomInfoHolder(View itemView) {
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
        if (viewType == ITEM_FOOTER){
            return new FooterHolder(inflater.inflate(R.layout.footer,parent,false));
        }else {
            return new sRoomInfoHolder(inflater.inflate(R.layout.item_room_number,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ITEM_NORMAL){
            sRoomInfoHolder itemHolder = (sRoomInfoHolder) holder;
            final String item = mDataSet.get(position);
            itemHolder.mRoomNumber.setText(item);

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
