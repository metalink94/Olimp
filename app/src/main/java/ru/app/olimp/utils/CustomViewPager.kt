package ru.app.olimp.utils

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.animation.Interpolator

import java.lang.reflect.Field

class CustomViewPager : ViewPager {
    private val mOffscreenPageLimit = DEFAULT_OFFSCREEN_PAGES

    private var isPagingEnabled = true
    private var mScroller: ScrollerCustomDuration? = null

    constructor(context: Context) : super(context) {
        postInitViewPager()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        postInitViewPager()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event)
    }

    fun setPagingEnabled(b: Boolean) {
        this.isPagingEnabled = b
    }

    /**
     * Override the Scroller instance with our own class so we can change the
     * duration
     */
    private fun postInitViewPager() {
        try {
            val scroller = ViewPager::class.java.getDeclaredField("mScroller")
            scroller.isAccessible = true
            val interpolator = ViewPager::class.java.getDeclaredField("sInterpolator")
            interpolator.isAccessible = true

            mScroller = ScrollerCustomDuration(context,
                    interpolator.get(null) as Interpolator)
            scroller.set(this, mScroller)
        } catch (e: Exception) {
            Log.e("VIEWPAGER", e.message)
        }

    }

    /**
     * Set the factor by which the duration will change
     */
    fun setScrollDurationFactor(scrollFactor: Double) {
        mScroller?.setScrollDurationFactor(scrollFactor)
    }

    companion object {

        private val TAG = "LazyViewPager"
        private val DEBUG = false

        private val USE_CACHE = false

        private val DEFAULT_OFFSCREEN_PAGES = 0//change default to load one page,no offset,ViewPager is 1,so cache 2 Fragment
        private val MAX_SETTLE_DURATION = 600 // ms
    }

}
