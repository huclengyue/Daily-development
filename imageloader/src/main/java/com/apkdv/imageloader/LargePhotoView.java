package com.apkdv.imageloader;

import android.content.Context;
import android.util.AttributeSet;

import com.apkdv.imageloader.listener.OnProgressListener;
import com.apkdv.imageloader.subscaleview.SubsamplingScaleImageView;
import com.apkdv.utils.DvLog;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * Created by android_ls on 2017/5/17.
 */

public class LargePhotoView extends SubsamplingScaleImageView {

    private OnProgressListener mOnProgressListener;

    public LargePhotoView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public LargePhotoView(Context context) {
        super(context);
    }

    public void setOnProgressListener(OnProgressListener listener) {
        this.mOnProgressListener = listener;
    }

    /**
     * 加载进度
     *
     * @param progress 0~100
     */
    public void onProgress(int progress) {
        DvLog.Companion.i("progress = " + progress);
        if (mOnProgressListener != null) {
            mOnProgressListener.onProgress(progress);
        }
    }


}
