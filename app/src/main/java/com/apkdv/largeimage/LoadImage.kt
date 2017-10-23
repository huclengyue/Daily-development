package com.apkdv.largeimage

import android.content.Context
import android.graphics.Point
import android.graphics.PointF
import android.view.WindowManager
import com.apkdv.imageloader.IMloader
import com.apkdv.imageloader.ImageLoader

import com.apkdv.largeimage.rollviewpager.DvViewUtil
import com.apkdv.utils.DvLog
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.ImageViewState
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView


/**
 * Created by LengYue on 2017/10/18.
 */
class LoadImage constructor(val url: String, val context: Context, var subsamplingScaleImageView: SubsamplingScaleImageView) {
val TAG = "LoadImage"
    init {
        subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM)
        subsamplingScaleImageView.minScale = 1.0f
        subsamplingScaleImageView.maxScale = 2.0f


        IMloader.with(context).setWidth(DvViewUtil.getScreenWidth()).setUrl(url).setResult({

            val sWidth: Float = it.width.toFloat()
            val sHeight: Float = it.height.toFloat()

            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            var my = Point()
            wm.defaultDisplay.getSize(my)
            DvLog.e(TAG,sWidth.toString())
            DvLog.e(TAG,my.x.toString())
            subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
            if (my.x >= sWidth && my.y >= sHeight) {
                subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE)
                subsamplingScaleImageView.minScale = 0.5f
                subsamplingScaleImageView.setImage(ImageSource.bitmap(it))
            } else {
                if (sWidth < sHeight) {
                    if ((sHeight / sWidth) >= 2.5) {
                        subsamplingScaleImageView.minScale = sWidth / my.x
                        subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP)
                        subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
                        subsamplingScaleImageView.setImage(ImageSource.bitmap(it), ImageViewState(0f, PointF(0f, 0f), 0))
                    }
                }
            }
        }).load()


//        val options = RequestOptions()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//                            .override(480, 800)
//        Glide.with(context).asBitmap()
//                .load(url)
//                .apply(options)
//                .listener(object : RequestListener<Bitmap> {
//                    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Bitmap>, isFirstResource: Boolean): Boolean {
//                        return false
//                    }
//
//                    override fun onResourceReady(resource: Bitmap, model: Any, target: Target<Bitmap>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
//                        return false
//                    }
//                }).into(object : SimpleTarget<Bitmap>() {
//
//            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>) {
//                subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
////                subsamplingScaleImageView.setImage(ImageSource.bitmap(resource), ImageViewState(1.0f, PointF(0f, 0f), 0))
//                val sWidth: Float = resource.width.toFloat()
//                val sHeight: Float = resource.height.toFloat()
//                val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
//                var my = Point()
//                wm.defaultDisplay.getSize(my)
//                subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
//                if (my.x >= sWidth && my.y >= sHeight) {
//                    subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE)
//                    subsamplingScaleImageView.minScale = 0.5f
//                    subsamplingScaleImageView.setImage(ImageSource.bitmap(resource))
//                } else {
//                    if (sWidth < sHeight) {
//                        if ((sHeight / sWidth) >= 2.5) {
//                            subsamplingScaleImageView.minScale = sWidth / my.x
//                            subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP)
//                            subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
//                            subsamplingScaleImageView.setImage(ImageSource.bitmap(resource), ImageViewState(0f, PointF(0f, 0f), 0))
//                        }
//                    }
//                }
//            }
//        })
    }
}