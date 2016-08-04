package com.twtstudio.wepeiyanglite.ui.gallery.GalleryPhoto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twtstudio.wepeiyanglite.R;
import com.twtstudio.wepeiyanglite.common.ui.PActivity;
import com.twtstudio.wepeiyanglite.model.GalleryPhotos;

import java.util.List;

import butterknife.BindView;

/**
 * Created by jcy on 2016/8/3.
 */

public class PhotoActivity extends PActivity<PhotoPresenter> implements PhotoViewController {
    @BindView(R.id.photo_toolbar)
    Toolbar mToolBar;
    @BindView(R.id.photo_collasping)
    ImageView mPhotoCollasping;
    @BindView(R.id.photo_collasping_content)
    TextView mContentCollasping;
    @BindView(R.id.photo_recyclerview)
    RecyclerView mRecyclerView;
    private int mId;
    private String mImageUrl;
    private String mContent;
    private String mTitle;
    private PhotoAdapter mAdapter;

    @Override
    protected PhotoPresenter getPresenter() {
        return new PhotoPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_gallery_photo;
    }

    @Override
    protected void actionStart(Context context) {
        Intent intent = getIntent();
        mId = intent.getIntExtra("id", 12);
        mImageUrl = (String) intent.getSerializableExtra("url");
        mContent = intent.getStringExtra("content");
        mTitle = intent.getStringExtra("name");
    }

    @Override
    protected int getStatusbarColor() {
        return android.R.color.holo_blue_dark;
    }

    @Override
    protected void preInitView() {
        Glide.with(this).load(mImageUrl).into(mPhotoCollasping);
        mContentCollasping.setText(mContent);
        getSupportActionBar().setTitle(".....");
        super.preInitView();
    }

    @Override
    protected void initView() {
        mAdapter=new PhotoAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getPhotos(mId);
    }

    @Override
    protected Toolbar getToolbar() {
        return mToolBar;
    }

    @Override
    public void refreshItems(List<GalleryPhotos> photosList) {
        mAdapter.refreshItems(photosList);
    }
}
