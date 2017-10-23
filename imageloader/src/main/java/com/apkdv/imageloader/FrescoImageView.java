package com.apkdv.imageloader;

import android.content.Context;
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
}