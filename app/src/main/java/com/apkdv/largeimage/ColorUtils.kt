package com.apkdv.largeimage

import android.graphics.Color

/**
 * Created by LengYue on 2017/10/19.
 */
class ColorUtils {
    companion object {
        fun parseBackgroundColor2(color: Int): Int {
            var counter = 0
            counter += if (Color.red(color) >= 128) 1 else 0
            counter += if (Color.green(color) >= 128) 1 else 0
            counter += if (Color.blue(color) >= 128) 1 else 0
            return if (counter >= 2) Color.BLACK else Color.WHITE
        }

        // 通过分析背景色来决定当前文字的匹配颜色，使文字颜色自适应背景颜色
        fun parseBackgroundColor(color: Int): Int {
            val red = Color.red(color)
            val green = Color.green(color)
            val blue = Color.blue(color)
            if (red >= 128 && green >= 128      // 三选二

                    || red >= 128 && blue >= 128
                    || green >= 128 && blue >= 128) {
                return Color.rgb(0, 0, 0)
            }
            return Color.rgb(255, 255, 255)
        }

        // #FF55FF => color
        // int color = Color.parseColor("#b64242");

        // color -> #FF55FF
        fun toRGBHexString(color: Int): String {
            return toRGBHexString(Color.red(color), Color.green(color), Color.blue(color))
        }

        fun toRGBHexString(alpha: Int, color: Int): String {
            return toARGBHexString(alpha, Color.red(color), Color.green(color), Color.blue(color))
        }

        // (r,g,b) -> #FF55FF
        fun toRGBHexString(red: Int, green: Int, blue: Int): String {
            return toARGBHexString(-1, red, green, blue)
        }

        // default prefix: "#"
        // (a,r,g,b) -> #FF55FF55
        fun toARGBHexString(alpha: Int, red: Int, green: Int, blue: Int): String {
            return toARGBHexString("#", alpha, red, green, blue)
        }

        fun toARGBHexString(prefix: String, alpha: Int, red: Int, green: Int, blue: Int): String {
            val sb = StringBuilder()
            sb.append(prefix)
            if (alpha != -1) {
                val mAlphaStr = Integer.toHexString(alpha)
                sb.append(if (mAlphaStr.length == 1) "0" + mAlphaStr else mAlphaStr)
            }
            val mRedStr = Integer.toHexString(red)
            sb.append(if (mRedStr.length == 1) "0" + mRedStr else mRedStr)
            val mGreenStr = Integer.toHexString(green)
            sb.append(if (mGreenStr.length == 1) "0" + mGreenStr else mGreenStr)
            val mBlueStr = Integer.toHexString(blue)
            sb.append(if (mBlueStr.length == 1) "0" + mBlueStr else mBlueStr)
            return sb.toString().toUpperCase()
        }

    }

}