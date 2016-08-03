package com.twtstudio.wepeiyanglite.ui.gallery;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.florent37.glidepalette.BitmapPalette;
import com.github.florent37.glidepalette.GlidePalette;
import com.twtstudio.wepeiyanglite.R;
import com.twtstudio.wepeiyanglite.common.ui.BaseAdapter;
import com.twtstudio.wepeiyanglite.common.ui.BaseViewHolder;
import com.twtstudio.wepeiyanglite.model.GalleryIndexItem;

import butterknife.BindView;

/**
 * Created by jcy on 2016/8/3.
 */

public class GalleryAdapter extends BaseAdapter<GalleryIndexItem> {

    private static final int ITEM_NORMAL = 0;
    private static final int ITEM_FOOTER = 1;

    public GalleryAdapter(Context context) {
        super(context);
    }

    static class sGalleryItemHolder extends BaseViewHolder {

        @BindView(R.id.gallery_index_photo)
        ImageView mIndexPhotoView;
        @BindView(R.id.gallery_title)
        TextView mTitleView;
        @BindView(R.id.gallery_description)
        TextView mDescriptionView;
        @BindView(R.id.gallery_card_view)
        CardView mCardView;

        public sGalleryItemHolder(View itemView) {
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
            return new sGalleryItemHolder(inflater.inflate(R.layout.item_gallery_index, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ITEM_NORMAL) {
            sGalleryItemHolder itemHolder = (sGalleryItemHolder) holder;
            GalleryIndexItem item = mDataSet.get(position);
            itemHolder.mTitleView.setText(item.title);
            itemHolder.mDescriptionView.setText(item.description);
            Glide.with(mContext).load(item.coverUrl)
                    .listener(GlidePalette.with(item.coverUrl)
                            .use(GlidePalette.Profile.VIBRANT)
                            .intoBackground(itemHolder.mCardView)
                    )
                    .into(itemHolder.mIndexPhotoView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= mDataSet.size()+1) {
            return -1;
        }else if (position == mDataSet.size()) {
            return ITEM_FOOTER;
        } else {
            return ITEM_NORMAL;
        }
    }
}
