package com.apkdv.largeimage.rollviewpager

import android.database.DataSetObserver
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup


/**
 * Created by LengYue on 2017/10/18.
 */
abstract class LoopPagerAdapter(private val mViewPager: RollPagerView) : PagerAdapter() {

    private val mViewList = arrayListOf<View>()

    init {
        mViewPager.setHintViewDelegate(LoopHintViewDelegate())
    }

    private inner class LoopHintViewDelegate : RollPagerView.HintViewDelegate {
        override fun setCurrentPosition(position: Int, hintView: HintView?) {
            if (hintView != null && getRealCount() > 0)
                hintView.setCurrent(position % getRealCount())
        }

        override fun initView(length: Int, gravity: Int, hintView: HintView?) {
            hintView?.initView(getRealCount(), gravity)
        }
    }

    override fun notifyDataSetChanged() {
        mViewList.clear()
        initPosition()
        super.notifyDataSetChanged()
    }

    override fun getItemPosition(`object`: Any?): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun registerDataSetObserver(observer: DataSetObserver) {
        super.registerDataSetObserver(observer)
        initPosition()
    }

    private fun initPosition() {
        if (mViewPager.viewPager.currentItem == 0 && getRealCount() > 0) {
            val half = Integer.MAX_VALUE / 2
            val start = half - half % getRealCount()
            setCurrent(start)
        }
    }

    private fun setCurrent(index: Int) {
        try {
            val field = ViewPager::class.java.getDeclaredField("mCurItem")
            field.isAccessible = true
            field.set(mViewPager.viewPager, index)
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

    }


    override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
        return arg0 === arg1
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val realPosition = position % getRealCount()
        val itemView = findViewByPosition(container, realPosition)
        container.addView(itemView)
        return itemView
    }


    private fun findViewByPosition(container: ViewGroup, position: Int): View {
        mViewList
                .filter { it.tag as Int == position && it.parent == null }
                .forEach { return it }
        val view = getView(container, position)
        view.tag = position
        mViewList.add(view)
        return view
    }

    abstract fun getView(container: ViewGroup, position: Int): View

    @Deprecated("", ReplaceWith("if (getRealCount() <= 0) getRealCount() else Integer.MAX_VALUE"))
    override fun getCount(): Int {
        return if (getRealCount() <= 0) getRealCount() else Integer.MAX_VALUE
    }

    abstract fun getRealCount(): Int
}