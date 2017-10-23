package com.apkdv.largeimage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.support.v7.graphics.Palette
import android.view.View
import android.view.ViewGroup
import com.apkdv.imageloader.IMloader
import com.apkdv.imageloader.ImageLoader
import com.apkdv.largeimage.imageLoadOld.FrescoImageView
import com.apkdv.largeimage.rollviewpager.StaticPagerAdapter
import com.facebook.imagepipeline.request.BasePostprocessor


/**
 * Created by LengYue on 2017/10/18.
 */
class TestNomalAdapter : StaticPagerAdapter() {
    private val imgs = intArrayOf(R.drawable.img1, R.drawable.img1, R.drawable.img3,
            R.drawable.img4)
    val img = arrayOf("http://static.oneplus.cn/data/attachment/portal/201710/20/180930x2j1ww11wtbab1v6.jpg",
            "http://static.oneplus.cn/data/attachment/portal/201710/19/155434kphffmoyk0f1pwp0.jpg",
            "http://static.oneplus.cn/data/attachment/portal/201710/18/114704l0m07gml30lmvlm7.png",
            "http://static.oneplus.cn/data/attachment/portal/201710/10/172558k62y9m96g8yp8e48.jpg")

    override fun getView(container: ViewGroup, position: Int): View {
        val holder = View.inflate(container.context, R.layout.item_sample_one2, null)
        var mPalette = holder.findViewById<FrescoImageView>(R.id.image)
        var shadowview = holder.findViewById<ShadowLayout>(R.id.shadow)

        ImageLoader.loadImage(mPalette, img[position], object : BasePostprocessor() {
            override fun process(bitmap: Bitmap?) {

                super.process(bitmap)
                    Palette.from(bitmap).maximumColorCount(1).generate { palette ->
                        //                        //获取颜色列表的第一个
                        val swatch = palette.swatches[0]
                        if (swatch != null) {
//                            shadowview.shadowColor = Color.parseColor(ColorUtils.toRGBHexString(127, swatch.rgb))
                                    shadowview.shadowColor = swatch.rgb
                        }
                    }
            }
        })
//
//        ImageLoader.loadDrawable(mPalette, imgs[position], object : BasePostprocessor() {
//            override fun process(bitmap: Bitmap?) {
//                super.process(bitmap)
//                bitmap?.let {
//                    Palette.from(bitmap).maximumColorCount(1).generate { palette ->
//                        //获取颜色列表的第一个
//                        val swatch = palette.swatches[0]
//                        if (swatch != null) {
//                            shadowview.shadowColor = Color.parseColor(ColorUtils.toRGBHexString(127, swatch.rgb))
////                                    shadowview.shadowColor = swatch.rgb
//                        }
//                    }
//                }
//            }
//        })

        return holder

    }


    fun getResUrl(context: Context, id: Int): String {
        return "res://${context.packageName}/$id"
    }

    override fun getCount(): Int {
        return imgs.size
    }

}