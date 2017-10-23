package com.apkdv.largeimage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.PointF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.apkdv.largeimage.R.id.subsamplingScaleImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.chenenyu.router.Router
import com.chenenyu.router.annotation.Route
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.ImageViewState
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import kotlinx.android.synthetic.main.activity_main.*

@Route("main2")
class MainActivity2 : BaseActivity() {
    override fun getLayoutId(): Int {
       return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        btn_jump.setOnClickListener {v -> Router.build(edit.text.toString()).go(this)  }
        subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);

//        subsamplingScaleImageView.minScale = 1.0F
//        subsamplingScaleImageView.setImage(ImageSource.asset("long_one.png"), ImageViewState(1.0f, PointF(0f, 0f), 0))

        subsamplingScaleImageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM)

        subsamplingScaleImageView.minScale = 1.0f//最小显示比例

        subsamplingScaleImageView.maxScale = 2.0f//最大显示比例（太大了图片显示会失真，因为一般微博长图的宽度不会太宽）
        val testUrl = "http://cache.attach.yuanobao.com/image/2016/10/24/332d6f3e63784695a50b782a38234bb7/da0f06f8358a4c95921c00acfd675b60.jpg"
        val testUrl2 = "https://user-gold-cdn.xitu.io/2017/5/25/74c8d908757f15357d26d1cd627f363e?imageView2/1/w/800/h/600/q/85/format/jpg/interlace/1"
        val testUrl3 = "https://ress.toyohu.com/mohoApp3/upload/aebdcf23-cc74-4095-bfc6-92518d59618e_87_20170928152328_image.jpg"
        LoadImage(testUrl2, this, subsamplingScaleImageView)

    }
}
