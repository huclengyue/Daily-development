package com.apkdv.largeimage

import android.graphics.Point
import android.net.Uri
import android.support.annotation.DrawableRes
import com.facebook.imagepipeline.request.Postprocessor
import android.content.res.Resources
import com.apkdv.largeimage.imageLoadOld.FrescoImageView
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder



/**
 * Created by LengYue on 2017/10/20.
 */
class ImageLoad {
    companion object {
        private val DEFAULTIMG = 1
        fun loadImage(simpleDraweeView: FrescoImageView, imageUri: String) {
            val uri = Uri.parse(if (imageUri.startsWith("http") or imageUri.startsWith("https")) imageUri
            else if (imageUri.startsWith("file://")) imageUri else "file://" + imageUri)
//            simpleDraweeView.setImageURI(url)
        }


        fun loadImageWithRounded(simpleDraweeView: FrescoImageView, url: String) {
            simpleDraweeView.setImageURI(url)
        }

        /**
         * 带默认图 加载图片
         */
        fun loadImage(imageView: FrescoImageView, uri: String, defaultImg: Int) {
            loadImage(imageView, uri, defaultImg, 0, false, false, true, null, null)
        }

        /**
         * 支持对图片大小重新修正
         */
        fun loadImage(imageView: FrescoImageView, uri: String, size: Point) {
            loadImage(imageView, uri, DEFAULTIMG, 0, false, false, true, size, null)
        }

        /**
         * 圆角图片
         */
        fun loadImage(imageView: FrescoImageView, uri: String, cornerRadius: Int, size: Point) {
            loadImage(imageView, uri, DEFAULTIMG, cornerRadius, false, false, true, size, null)
        }

        /**
         * 本地图片
         */
        fun loadImage(imageView: FrescoImageView, @DrawableRes defaultImg: Int) {
            loadImage(imageView, "", defaultImg, 10, false, true, true, null, null)
        }


        fun loadImage(imageView: FrescoImageView, uri: String, defaultImg: Int, cornerRadius: Int, loadLocalPath: Boolean, size: Point) {
            loadImage(imageView, uri, defaultImg, cornerRadius, false, loadLocalPath, true, size, null)
        }

        fun loadImage(imageView: FrescoImageView, uri: String, defaultImg: Int, loadLocalPath: Boolean, postprocessor: Postprocessor) {
            loadImage(imageView, uri, defaultImg, 0, false, loadLocalPath, true, null, postprocessor)
        }

        fun loadImage(imageView: FrescoImageView, uri: String, defaultImg: Int, loadLocalPath: Boolean, point: Point, postprocessor: Postprocessor) {
            loadImage(imageView, uri, defaultImg, 0, false, loadLocalPath, true, point, postprocessor)
        }

        fun loadImage(imageView: FrescoImageView, uri: String, defaultImg: Int, radius: Int, loadLocalPath: Boolean, point: Point, postprocessor: Postprocessor) {
            loadImage(imageView, uri, defaultImg, radius, false, loadLocalPath, true, point, postprocessor)
        }

        fun loadImage(imageView: FrescoImageView, uri: String, defaultImg: Int, cornerRadius: Int, loadLocalPath: Boolean) {
            loadImage(imageView, uri, defaultImg, cornerRadius, false, loadLocalPath, true, null, null)
        }

        fun loadImageCircle(imageView: FrescoImageView, uri: String, defaultImg: Int, loadLocalPath: Boolean) {
            loadImage(imageView, uri, defaultImg, 0, true, loadLocalPath, true, null, null)
        }

        /**
         * @param imageView     图片加载控件
         * @param uri           路径或者URL
         * @param defaultImg    默认图片
         * @param cornerRadius  弧形角度
         * @param isCircle      是否为圆
         * @param loadLocalPath 是否本地资源,如果显示R.drawable.xxx,Path可以为null,前提isCircle为true
         * @param size          是否再编码
         * @param postprocessor 图像显示处理
         */
        fun loadImage(imageView: FrescoImageView, uri: String, defaultImg: Int,
                      cornerRadius: Int, isCircle: Boolean, loadLocalPath: Boolean, isAnima: Boolean,
                      size: Point?, postprocessor: Postprocessor?) {
            val hierarchy = GenericDraweeHierarchyBuilder.newInstance(Resources.getSystem())
                    .setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
                    .setPlaceholderImage(defaultImg)
                    .setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
                    .build()
            imageView.hierarchy = hierarchy
            imageView.setImageURI(uri)
        }



    }
}