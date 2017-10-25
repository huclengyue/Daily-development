package com.apkdv.largeimage

import android.content.Context
import android.graphics.Point
import android.graphics.PointF
import android.view.View
import android.view.WindowManager
import com.apkdv.imageloader.IMloader
import com.apkdv.imageloader.subscaleview.ImageSource
import com.apkdv.imageloader.subscaleview.ImageViewState
import com.apkdv.imageloader.subscaleview.SubsamplingScaleImageView
import com.apkdv.largeimage.rollviewpager.DvViewUtil
import com.github.chrisbanes.photoview.PhotoView


/**
 * Created by LengYue on 2017/10/18.
 */
class LoadImage(url: String, context: Context, subsamplingScaleImageView: SubsamplingScaleImageView) {

    init {
        LoadImage(context, url, null, subsamplingScaleImageView)
    }

    private fun LoadImage(context: Context, url: String, photoview: PhotoView?, subsamplingScaleImageView: SubsamplingScaleImageView) {
        IMloader.with(context).setWidth(DvViewUtil.getScreenWidth()).setUrl(url).setResult({
            val sWidth: Float = it.width.toFloat()
            val sHeight: Float = it.height.toFloat()
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            var my = Point()
            wm.defaultDisplay.getSize(my)
            if (my.x >= sWidth && my.y >= sHeight) {
                //使用photoview加载小图，更强大的缩放效果
                if (null != photoview) {
                    photoview.minimumScale = 0.5f
                    photoview.maximumScale = 2f
                    photoview.setScale(1f, true)
                    photoview.setImageBitmap(it)
                    subsamplingScaleImageView.visibility = View.GONE
                } else {
                    subsamplingScaleImageView.setDoubleTapZoomScale(1f)
                    subsamplingScaleImageView.maxScale = 2f
                    subsamplingScaleImageView.minScale = 0.5f
                    subsamplingScaleImageView.setImage(ImageSource.bitmap(it), ImageViewState(1f,
                            PointF(0f, 0f), 0))
                }
            } else {
                //加载长图
                photoview?.apply { photoview.visibility = View.GONE }
                //720/x = 256
                subsamplingScaleImageView.setDoubleTapZoomScale(my.x / sWidth)
                subsamplingScaleImageView.maxScale = my.x / sWidth + 2
                subsamplingScaleImageView.setImage(ImageSource.bitmap(it), ImageViewState(my.x / sWidth,
                        PointF(0f, 0f), 0))
            }
        }).load()
    }

    constructor(url: String, context: Context, photoview: PhotoView?, subsamplingScaleImageView: SubsamplingScaleImageView) :
            this(url, context, subsamplingScaleImageView) {
        LoadImage(context, url, photoview, subsamplingScaleImageView)
    }
}