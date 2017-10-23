package com.apkdv.largeimage.imageLoadOld;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by LengYue on 2017/10/20.
 */

public class FrescoImageView extends SimpleDraweeView {


    public FrescoImageView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public FrescoImageView(Context context) {
        super(context);
    }

    public FrescoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FrescoImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FrescoImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void loadLocalImage(FrescoConfig config) {
        try {

            this.getHierarchy().setPlaceholderImage(config.mDefaultResID);

            if (TextUtils.isEmpty(config.mThumbnailPath)) {
                FrescoFactory2.setResourceController(this, config);
                return;
            }
            if (!config.mThumbnailPath.startsWith(FrescoConfig.FILE_PERFIX)) {
                config.mThumbnailPath = FrescoConfig.FILE_PERFIX + config.mThumbnailPath;
            }
            FrescoFactory2.setSourceController(this, config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public void loadView(FrescoConfig config) {
        try {
            if (!TextUtils.isEmpty(config.mThumbnailUrl)
                    && (config.mThumbnailUrl.startsWith(FrescoConfig.HTTP_PERFIX)
                    || config.mThumbnailUrl.startsWith(FrescoConfig.HTTPS_PERFIX))) {
                this.getHierarchy().setPlaceholderImage(config.mDefaultResID);
                FrescoFactory2.setSourceController(this, config);
                return;
            }
            this.getHierarchy().setPlaceholderImage(config.mDefaultResID);
            FrescoFactory2.setResourceController(this, config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }


}