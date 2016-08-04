package com.twtstudio.wepeiyanglite.ui.gallery.GalleryPhoto;

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
import com.twtstudio.wepeiyanglite.model.GalleryPhotos;

import butterknife.BindView;

/**
 * Created by jcy on 2016/8/4.
 */

public class PhotoAdapter extends BaseAdapter<GalleryPhotos> {

    private static final int ITEM_NORMAL = 0;
    private static final int ITEM_FOOTER = 1;

    public PhotoAdapter(Context context) {
        super(context);
    }

    static class sPhotoItemHolder extends BaseViewHolder {

        @BindView(R.id.photo_image)
        ImageView mPhotoImage;
        @BindView(R.id.photo_title)
        TextView mPhotoTitle;
        @BindView(R.id.photo_author)
        TextView mPhotoAuthor;
        @BindView(R.id.photo_card_view)
        CardView mCardView;

        public sPhotoItemHolder(View itemView) {
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
            return new sPhotoItemHolder(inflater.inflate(R.layout.item_photo, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ITEM_NORMAL) {
            sPhotoItemHolder itemHolder = (sPhotoItemHolder) holder;
            final GalleryPhotos item = mDataSet.get(position);
            itemHolder.mPhotoAuthor.setText(item.author);
            itemHolder.mPhotoTitle.setText(item.title);
            Glide.with(mContext).load(item.thumbnailUrl)
                    .listener(GlidePalette.with(item.thumbnailUrl)
                            .use(GlidePalette.Profile.VIBRANT)
                            .intoBackground(itemHolder.mCardView)
                    )
                    .into(itemHolder.mPhotoImage);
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
