package com.apkdv.largeimage

import android.content.Context
import android.graphics.Color
import android.support.v7.graphics.Palette
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.apkdv.imageloader.ImageLoader
import com.apkdv.largeimage.rollviewpager.StaticPagerAdapter
import com.apkdv.largeimage.shadow.ShadowView
import com.apkdv.middleware.wedgit.roundedimageview.RoundedImageView

/**
 * Created by LengYue on 2017/10/18.
 */
class TestNomalAdapter2 : StaticPagerAdapter() {
    val img = arrayOf("http://static.oneplus.cn/data/attachment/portal/201710/20/180930x2j1ww11wtbab1v6.jpg",
            "http://static.oneplus.cn/data/attachment/portal/201710/19/155434kphffmoyk0f1pwp0.jpg",
            "http://static.oneplus.cn/data/attachment/portal/201710/18/114704l0m07gml30lmvlm7.png",
            "http://static.oneplus.cn/data/attachment/portal/201710/10/172558k62y9m96g8yp8e48.jpg")

    override fun getView(container: ViewGroup, position: Int): View {
        val holder = View.inflate(container.context, R.layout.item_sample_one, null)
        var mPalette = holder.findViewById<RoundedImageView>(R.id.image)
        var shadowview = holder.findViewById<ShadowLayout>(R.id.shadow_view)



        ImageLoader.loadImage(container.context, img[position]) { result ->
            result?.apply {
                Palette.from(result).maximumColorCount(1).generate { palette ->
                    //获取颜色列表的第一个
                    mPalette.setImageBitmap(result)
                    val swatch = palette.swatches[0]
                    if (swatch != null) {
                        shadowview.shadowColor = Color.parseColor(ColorUtils.toRGBHexString(150, swatch.rgb))
//                                    shadowview.shadowColor = swatch.rgb
                    }
                }
            }

        }

        return holder
    }

    override fun getCount(): Int {
        return img.size
    }

}