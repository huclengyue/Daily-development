package com.apkdv.largeimage

import android.app.Application
import com.apkdv.utils.DvLog
import com.chenenyu.router.Router
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import okhttp3.OkHttpClient

/**
 * Created by LengYue on 2017/10/18.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // debug模式,显示log
        if (BuildConfig.DEBUG) {
            Router.setDebuggable(true)
        }
        val mOkHttpClient = OkHttpClient()
        var config = OkHttpImagePipelineConfigFactory
                .newBuilder(this, mOkHttpClient)
                .build()

        Router.initialize(this)
        Fresco.initialize(this, config)
        DvLog.setShow(true)
    }
}