package com.twtstudio.wepeiyanglite.ui.gallery;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.twtstudio.wepeiyanglite.R;
import com.twtstudio.wepeiyanglite.common.ui.PFragment;
import com.twtstudio.wepeiyanglite.model.GalleryIndexItem;

import java.util.List;

import butterknife.BindView;

/**
 * Created by jcy on 2016/8/3.
 */

public class GalleryFragment extends PFragment<GalleryPresenter> implements GalleryViewController {

    @BindView(R.id.fragment_gallery_rcv)
    RecyclerView mGalleryRcv;
    private GalleryAdapter mAdapter;

    @Override
    protected GalleryPresenter getPresenter() {
        return new GalleryPresenter(getActivity(), this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_gallery;
    }

    @Override
    protected void initView() {
        mAdapter=new GalleryAdapter(getContext());
        //refresh
        mPresenter.getGallery();
        mGalleryRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mGalleryRcv.setAdapter(mAdapter);
    }

    @Override
    public void refreshItems(List<GalleryIndexItem> items) {
        mAdapter.refreshItems(items);
    }
}
