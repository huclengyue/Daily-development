package com.apkdv.utils

import android.util.Log
import java.lang.Exception

/**
 * Created by LengYue on 2017/9/26.
 */
class DvLog {
    companion object {

        private val TAG = "DvLog"
        private var isShowLog: Boolean = false
        fun setShow(isShow: Boolean) {
            isShowLog = isShow
        }

        fun getIsShow(): Boolean {
            return isShowLog
        }

        fun i(log: String) {
            if (isShowLog)
                Log.i(TAG, log)
        }

        fun i(tag: String, log: String) {

            if (isShowLog)
                Log.i(tag, log)
        }


        fun d(tag: String, log: String) {
            if (isShowLog)
                Log.i(tag, log)
        }

        fun d(log: String) {
            if (isShowLog)
                Log.d(TAG, log)
        }


        fun e(tag: String, log: String) {
            if (isShowLog)
                Log.e(tag, log)
        }


        fun e(log: String) {
            if (isShowLog)
                Log.e(TAG, log)
        }

        fun e(e: Exception) {
            if (isShowLog)
                Log.e(TAG, e.toString())
        }

        fun w(log: String) {
            if (isShowLog)
                Log.w(TAG, log)
        }

        fun w(tag: String, log: String) {
            if (isShowLog)
                Log.w(tag, log)
        }
    }


}