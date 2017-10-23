package com.apkdv.largeimage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.support.v7.graphics.Palette
import android.view.View
import android.view.ViewGroup
import com.apkdv.largeimage.imageLoadOld.FrescoImageView
import com.apkdv.largeimage.rollviewpager.StaticPagerAdapter
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.generic.RoundingParams
import com.facebook.imagepipeline.request.BasePostprocessor
import com.facebook.imagepipeline.request.ImageRequestBuilder


/**
 * Created by LengYue on 2017/10/18.
 */
class TestNomalAdapter : StaticPagerAdapter() {
    private val imgs = intArrayOf(R.drawable.img1, R.drawable.img1, R.drawable.img3,
            R.drawable.img4)

    override fun getView(container: ViewGroup, position: Int): View {
        val holder = View.inflate(container.context, R.layout.item_sample_one2, null)
        var mPalette = holder.findViewById<FrescoImageView>(R.id.image)
        var shadowview = holder.findViewById<ShadowLayout>(R.id.shadow)
        mPalette.setImageURI(getResUrl(container.context, imgs[position]))

        var request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(getResUrl(container.context, imgs[position])))
                .setPostprocessor(object : BasePostprocessor() {
                    override fun process(bitmap: Bitmap?) {
                        super.process(bitmap)
                        bitmap?.let {
                            Palette.from(bitmap).maximumColorCount(1).generate { palette ->
                                //获取颜色列表的第一个
                                val swatch = palette.swatches[0]
                                if (swatch != null) {
                                    shadowview.shadowColor = Color.parseColor(ColorUtils.toRGBHexString(127,swatch.rgb))
//                                    shadowview.shadowColor = swatch.rgb
                                }
                            }
                        }
                    }
                }).build()

        var controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build()

        mPalette.controller = controller;

        return holder

    }


    fun getResUrl(context: Context, id: Int): String {
        return "res://${context.packageName}/$id"
    }

    override fun getCount(): Int {
        return imgs.size
    }

}