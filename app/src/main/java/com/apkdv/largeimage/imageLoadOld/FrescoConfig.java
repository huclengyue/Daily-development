package com.apkdv.largeimage.imageLoadOld;

import android.graphics.Point;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

/**
 * Created by LengYue on 2017/10/20.
 */

public class FrescoConfig {
    public final static String HTTP_PERFIX = "http://";
    public final static String HTTPS_PERFIX = "https://";
    public final static String FILE_PERFIX = "file://";

    public String mThumbnailUrl = null;
    public String mLowThumbnailUrl = null;//低分辨率Url
    public int mDefaultResID = 0;
    public ImageRequest mRequest;
    public boolean mAnim = true;//默认开启动画
    public String mThumbnailPath = null;
    public ControllerListener mControllerListener;
    public Postprocessor mPostProcessor;
    public DraweeController mController;
    public ImageRequest mLowResRequest;
    public boolean mTapToRetry = false;
    public boolean mAutoRotateEnabled = false;
    public boolean resize = false;
    public Point reSize;
    public boolean isCircle;
    public boolean loadLocalPath;
    public float cornerRadius;


    public FrescoConfig() {
    }

    public FrescoConfig(String thumbnailUrl, String lowThumbnailUrl,
                        int defaultResID, ImageRequest request,
                        boolean anim, String thumbnailPath,
                        ControllerListener controllerListener,
                        Postprocessor postProcessor,
                        DraweeController controller,
                        ImageRequest lowResRequest,
                        boolean tapToRetry,
                        boolean autoRotateEnabled,
                        boolean resize,
                        Point reSize) {
        mThumbnailUrl = thumbnailUrl;
        mLowThumbnailUrl = lowThumbnailUrl;
        mDefaultResID = defaultResID;
        mRequest = request;
        mAnim = anim;
        mThumbnailPath = thumbnailPath;
        mControllerListener = controllerListener;
        mPostProcessor = postProcessor;
        mController = controller;
        mLowResRequest = lowResRequest;
        mTapToRetry = tapToRetry;
        mAutoRotateEnabled = autoRotateEnabled;
        this.resize = resize;
        this.reSize = reSize;
    }




    public static class Builder {
        FrescoConfig mFrescoConfig;

        public Builder() {
            mFrescoConfig = new FrescoConfig();
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            mFrescoConfig.mThumbnailUrl = thumbnailUrl;
            return this;
        }

        public Builder setLowThumbnailUrl(String lowThumbnailUrl) {
            mFrescoConfig.mLowThumbnailUrl = lowThumbnailUrl;
            return this;
        }

        public Builder setDefaultResID(int defaultResID) {
            mFrescoConfig.mDefaultResID = defaultResID;
            return this;
        }

        public Builder setRequest(ImageRequest request) {
            mFrescoConfig.mRequest = request;
            return this;
        }

        public Builder setAnim(boolean anim) {
            mFrescoConfig.mAnim = anim;
            return this;
        }

        public Builder setThumbnailPath(String thumbnailPath) {
            mFrescoConfig.mThumbnailPath = thumbnailPath;
            return this;
        }

        public Builder setControllerListener(ControllerListener controllerListener) {
            mFrescoConfig.mControllerListener = controllerListener;
            return this;
        }

        public Builder setPostProcessor(Postprocessor postProcessor) {
            mFrescoConfig.mPostProcessor = postProcessor;
            return this;
        }

        public Builder setController(DraweeController controller) {
            mFrescoConfig.mController = controller;
            return this;
        }

        public Builder setLowResRequest(ImageRequest lowResRequest) {
            mFrescoConfig.mLowResRequest = lowResRequest;
            return this;
        }

        public Builder setTapToRetry(boolean tapToRetry) {
            mFrescoConfig.mTapToRetry = tapToRetry;
            return this;
        }

        public Builder setAutoRotateEnabled(boolean autoRotateEnabled) {
            mFrescoConfig.mAutoRotateEnabled = autoRotateEnabled;
            return this;
        }

        public Builder setResize(boolean resize) {
            mFrescoConfig.resize = resize;
            return this;
        }

        public Builder setReSize(Point reSize) {
            mFrescoConfig.reSize = reSize;
            return this;
        }

        public Builder setCircle(boolean isCircle) {
            mFrescoConfig.isCircle = isCircle;
            return this;
        }

        public Builder setCornerRadius(float cornerRadius) {
            mFrescoConfig.cornerRadius = cornerRadius;
            return this;
        }

        public Builder setLoadLocalPath(boolean loadLocalPath) {
            mFrescoConfig.loadLocalPath = loadLocalPath;
            return this;
        }

        public FrescoConfig build() {
            return mFrescoConfig;
        }

    }
}
