package com.apkdv.largeimage

import android.os.Bundle
import com.chenenyu.router.annotation.Route
import kotlinx.android.synthetic.main.activity_main.*

@Route("main3")
class MainActivity3 : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val testUrl2 = "http://game.gtimg.cn/upload/adw/image/1492741296/1492741296.jpg?_r=1508234557"
        val testUrl3 = "https://ress.toyohu.com/mohoApp3/upload/aebdcf23-cc74-4095-bfc6-92518d59618e_87_20170928152328_image.jpg"

        val testUrl = "https://user-gold-cdn.xitu.io/2017/5/25/74c8d908757f15357d26d1cd627f363e?imageView2/1/w/800/h/600/q/85/format/jpg/interlace/1"

//        LoadImage(testUrl2, this, subsamplingScaleImageView)
        LoadImage(testUrl3, this, photo_view, subsamplingScaleImageView)

    }
}