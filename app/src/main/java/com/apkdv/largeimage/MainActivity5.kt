package com.apkdv.largeimage


import android.graphics.PointF
import android.os.Bundle
import com.apkdv.imageloader.IMloader
import com.apkdv.imageloader.subscaleview.ImageSource
import com.apkdv.imageloader.subscaleview.ImageViewState
import com.apkdv.imageloader.subscaleview.SubsamplingScaleImageView
import com.apkdv.largeimage.rollviewpager.DvViewUtil
import com.chenenyu.router.annotation.Route
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


        subsamplingScaleImageView.orientation = SubsamplingScaleImageView.ORIENTATION_USE_EXIF
        LoadImage(testUrl3, this, photo_view, subsamplingScaleImageView)

    }


}
