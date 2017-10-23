package com.apkdv.largeimage


import android.os.Bundle
import com.apkdv.largeimage.zoomable.DoubleTapGestureListener
import com.apkdv.largeimage.zoomable.ZoomableDraweeView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chenenyu.router.Router
import com.chenenyu.router.annotation.Route
import com.facebook.drawee.backends.pipeline.Fresco


@Route("main1")
class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main_test
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Router.build("main4").go(this)

        val testUrl = "http://cache.attach.yuanobao.com/image/2016/10/24/332d6f3e63784695a50b782a38234bb7/da0f06f8358a4c95921c00acfd675b60.jpg"
        val testUrl2 = "https://user-gold-cdn.xitu.io/2017/5/25/74c8d908757f15357d26d1cd627f363e?imageView2/1/w/800/h/600/q/85/format/jpg/interlace/1"
        val testUrl3 = "https://ress.toyohu.com/mohoApp3/upload/aebdcf23-cc74-4095-bfc6-92518d59618e_87_20170928152328_image.jpg"
//        LoadImage(testUrl, this, subsamplingScaleImageView)
        val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//                            .override(480, 800)
//        val image: ZoomableDraweeView = findViewById(R.id.image)
//
//        image.setAllowTouchInterceptionWhileZoomed(true)
//        // needed for double tap to zoom
//        image.setIsLongpressEnabled(false)
//        image.setTapListener(DoubleTapGestureListener(image))
//        val controller = Fresco.newDraweeControllerBuilder()
//                .setUri(testUrl)
//                .setCallerContext("ZoomableApp-MyPagerAdapter")
//                .build()
//        image.controller = controller
//        image.setImageURI(testUrl)

    }
}
