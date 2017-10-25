package com.apkdv.largeimage


import android.os.Bundle
import com.chenenyu.router.Router
import com.chenenyu.router.annotation.Route
import kotlinx.android.synthetic.main.activity_main.*


@Route("main1")
class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Router.build("main2").go(this)
        val testUrl = "http://cache.attach.yuanobao.com/image/2016/10/24/332d6f3e63784695a50b782a38234bb7/da0f06f8358a4c95921c00acfd675b60.jpg"
        val testUrl2 = "https://user-gold-cdn.xitu.io/2017/5/25/74c8d908757f15357d26d1cd627f363e?imageView2/1/w/800/h/600/q/85/format/jpg/interlace/1"
        val testUrl3 = "https://ress.toyohu.com/mohoApp3/upload/aebdcf23-cc74-4095-bfc6-92518d59618e_87_20170928152328_image.jpg"
        LoadImage(testUrl, this, subsamplingScaleImageView)

    }
}
