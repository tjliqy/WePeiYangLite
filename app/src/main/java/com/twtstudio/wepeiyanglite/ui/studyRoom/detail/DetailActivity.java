package com.twtstudio.wepeiyanglite.ui.studyRoom.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.twtstudio.wepeiyanglite.R;
import com.twtstudio.wepeiyanglite.common.ui.PActivity;
import com.twtstudio.wepeiyanglite.model.AvailableRoom;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jcy on 2016/8/4.
 */

public class DetailActivity extends PActivity<DetailPresenter> implements DetailViewController {
    @BindView(R.id.detail_toolbar)
    Toolbar mtoolbar;
    @BindView(R.id.available_rooms_rcv)
    RecyclerView mRecyclerView;

    private int mBid;
    private String mBuildingName;
    private DetailAdapter mAdapter;

    @Override
    protected DetailPresenter getPresenter() {
        return new DetailPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_available_rooms;
    }

    @Override
    protected void actionStart(Context context) {
        Intent intent = getIntent();
        mBid = intent.getIntExtra("bid", 17);
        mBuildingName = intent.getStringExtra("name") + " 楼";
    }

    @Override
    protected int getStatusbarColor() {
        return android.R.color.black;
    }

    @Override
    protected void initView() {
        getSupportActionBar().setTitle(mBuildingName);
        mAdapter = new DetailAdapter(this);
        String timeStamp = Calendar.getInstance().getTimeInMillis() + "";
        mPresenter.refreshItems(mBid, timeStamp);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected Toolbar getToolbar() {
        return mtoolbar;
    }

    @Override
    public void refreshItems(List<String> availableRoomList) {
        mAdapter.refreshItems(availableRoomList);
    }
}
