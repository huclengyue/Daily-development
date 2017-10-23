package com.apkdv.largeimage


import android.content.Context
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.PointF
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.support.annotation.Nullable
import android.view.WindowManager
import com.chenenyu.router.annotation.Route
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.ImageViewState
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import com.facebook.common.executors.CallerThreadExecutor
import com.facebook.common.executors.UiThreadImmediateExecutorService
import com.facebook.common.references.CloseableReference
import com.facebook.datasource.DataSource
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
import com.facebook.imagepipeline.image.CloseableImage
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_test.*


@Route("main5")
class MainActivity5 : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val testUrl = "http://cache.attach.yuanobao.com/image/2016/10/24/332d6f3e63784695a50b782a38234bb7/da0f06f8358a4c95921c00acfd675b60.jpg"
        val testUrl3 = "https://ress.toyohu.com/mohoApp3/upload/aebdcf23-cc74-4095-bfc6-92518d59618e_87_20170928152328_image.jpg"
//        zoomabledraweeview.setAllowTouchInterceptionWhileZoomed(true)
//        // needed for double tap to zoom
//        zoomabledraweeview.setIsLongpressEnabled(false)
//        zoomabledraweeview.setTapListener(DoubleTapGestureListener(zoomabledraweeview))
//        val controller = Fresco.newDraweeControllerBuilder()
//                .setUri(testUrl)
//                .setCallerContext("ZoomableApp-MyPagerAdapter")
//                .build()
//        zoomabledraweeview.controller = controller

//        getBitmap(this, testUrl)?.let {
//            imageview.setImageBitmap(it)
//        }
        downLoadImg(Uri.parse(testUrl3))


    }

    val TAG = "MainActivity5";

    private fun downLoadImg(uri: Uri) {
        val imageRequest = ImageRequestBuilder
                .newBuilderWithSource(uri)
                .setAutoRotateEnabled(true)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .setProgressiveRenderingEnabled(true)
                //                .setResizeOptions()
                .build()
//        val imageRequest = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build()
        val imagePipeline = Fresco.getImagePipeline()
        val dataSource = imagePipeline.fetchDecodedImage(imageRequest, this)
        dataSource.subscribe(object : BaseBitmapDataSubscriber() {
            public override fun onNewResultImpl(@Nullable bitmap: Bitmap?) {
                //bitmap即为下载所得图片
                bitmap?.apply {
//                    imageview.setImageBitmap(bitmap)
                    subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
//                subsamplingScaleImageView.setImage(ImageSource.bitmap(resource), ImageViewState(1.0f, PointF(0f, 0f), 0))
                    val sWidth: Float = bitmap.width.toFloat()
                    val sHeight: Float = bitmap.height.toFloat()
                    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
                    var my = Point()
                    wm.defaultDisplay.getSize(my)
                    subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
                    if (my.x >= sWidth && my.y >= sHeight) {
                        subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE)
                        subsamplingScaleImageView.minScale = 0.5f
                        subsamplingScaleImageView.setImage(ImageSource.bitmap(bitmap))
                    } else {
                        if (sWidth < sHeight) {
                            if ((sHeight / sWidth) >= 2.5) {
                                subsamplingScaleImageView.minScale = sWidth / my.x
                                subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP)
                                subsamplingScaleImageView.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER_IMMEDIATE)
                                subsamplingScaleImageView.setImage(ImageSource.bitmap(bitmap), ImageViewState(1f, PointF(0f, 0f), 0))
                            }
                        }
                    }
                    dataSource.close()
                }
            }

            override fun onFailureImpl(dataSource: DataSource<CloseableReference<CloseableImage>>?) {

            }
        }, UiThreadImmediateExecutorService.getInstance())


    }


}
