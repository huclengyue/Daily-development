package com.apkdv.largeimage


import android.graphics.PointF
import android.os.Bundle
import com.apkdv.imageloader.IMloader
import com.apkdv.largeimage.rollviewpager.DvViewUtil
import com.chenenyu.router.annotation.Route
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.ImageViewState
import kotlinx.android.synthetic.main.activity_main.*


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

        IMloader.with(this).setWidth(DvViewUtil.getScreenWidth()).setUrl(testUrl).setResult({
            subsamplingScaleImageView.setImage(ImageSource.bitmap(it), ImageViewState(0f, PointF(0f, 0f), 0)) }).load()

//        LoadImage(testUrl, this, subsamplingScaleImageView)
    }


}
