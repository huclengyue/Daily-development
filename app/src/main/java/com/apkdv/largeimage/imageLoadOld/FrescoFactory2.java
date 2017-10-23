package com.apkdv.largeimage.imageLoadOld;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by LengYue on 2017/10/20.
 */

public class FrescoFactory2 {

    public static ImageRequest buildImageRequestWithResource(FrescoConfig frescoConfig) {
        return ImageRequestBuilder.newBuilderWithResourceId(frescoConfig.mDefaultResID)
                .setPostprocessor(frescoConfig.mPostProcessor)
                .setAutoRotateEnabled(frescoConfig.mAutoRotateEnabled)
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
    }

    public static ImageRequest buildImageRequestWithResource(FrescoConfig frescoConfig, Point size) {
        return ImageRequestBuilder.newBuilderWithResourceId(frescoConfig.mDefaultResID)
                .setPostprocessor(frescoConfig.mPostProcessor)
                .setAutoRotateEnabled(frescoConfig.mAutoRotateEnabled)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(size.x, size.y))
                .build();
    }


    public static ImageRequest buildImageRequestWithSource(FrescoConfig frescoConfig) {
        String thumbnail;
        if (TextUtils.isEmpty(frescoConfig.mThumbnailUrl)) {
            thumbnail = frescoConfig.mThumbnailPath;
        } else {
            thumbnail = frescoConfig.mThumbnailUrl;
        }
        Uri uri = Uri.parse(thumbnail);
        return ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(frescoConfig.mPostProcessor)
                .setAutoRotateEnabled(frescoConfig.mAutoRotateEnabled)
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
    }

    public static ImageRequest buildImageRequestWithSource(FrescoConfig frescoConfig, Point size) {
        String thumbnail = null;
        if (TextUtils.isEmpty(frescoConfig.mThumbnailUrl)) {
            thumbnail = frescoConfig.mThumbnailPath;
        } else {
            thumbnail = frescoConfig.mThumbnailUrl;
        }
        Uri uri = Uri.parse(thumbnail);
        return ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(frescoConfig.mPostProcessor)
                .setAutoRotateEnabled(frescoConfig.mAutoRotateEnabled)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(size.x, size.y))
                .build();
    }

    public static ImageRequest buildLowImageRequest(FrescoConfig frescoConfig) {
        String lowThumbnail = null;
        if (TextUtils.isEmpty(frescoConfig.mLowThumbnailUrl)) {
            return null;
        }
        lowThumbnail = frescoConfig.mLowThumbnailUrl;
        Uri uri = Uri.parse(lowThumbnail);
        return ImageRequest.fromUri(uri);
    }

    public static DraweeController buildDraweeController(FrescoConfig frescoConfig) {
        return Fresco.newDraweeControllerBuilder()
                .setImageRequest(frescoConfig.mRequest)
                .setAutoPlayAnimations(frescoConfig.mAnim)
                .setTapToRetryEnabled(frescoConfig.mTapToRetry)
                .setLowResImageRequest(frescoConfig.mLowResRequest)
                .setControllerListener(frescoConfig.mControllerListener)
                .setOldController(frescoConfig.mController)
                .build();
    }

    public static void setSourceController(SimpleDraweeView draweeView, FrescoConfig frescoConfig) {
        frescoConfig.mRequest = (frescoConfig.reSize != null) ?
                FrescoFactory2.buildImageRequestWithSource(frescoConfig, frescoConfig.reSize) :
                FrescoFactory2.buildImageRequestWithSource(frescoConfig);
        frescoConfig.mLowResRequest = FrescoFactory2.buildLowImageRequest(frescoConfig);
        frescoConfig.mController = FrescoFactory2.buildDraweeController(frescoConfig);
        draweeView.setController(frescoConfig.mController);

    }

    public static void setResourceController(SimpleDraweeView draweeView, FrescoConfig frescoConfig) {
        frescoConfig.mRequest = (frescoConfig.reSize != null) ? FrescoFactory2.buildImageRequestWithResource(frescoConfig, frescoConfig.reSize) :
                FrescoFactory2.buildImageRequestWithResource(frescoConfig);
        frescoConfig.mController = FrescoFactory2.buildDraweeController(frescoConfig);
        draweeView.setController(frescoConfig.mController);
    }


}
