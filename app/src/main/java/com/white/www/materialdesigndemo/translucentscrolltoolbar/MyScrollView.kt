package com.white.www.materialdesigndemo.translucentscrolltoolbar

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView
import java.util.jar.Attributes

/**
 * Author: White
 * Time:2018/7/21 15:58
 * Description:
 */
class MyScrollView : ScrollView {

    constructor(context:Context) : super(context)
    constructor(context:Context,attrs:AttributeSet) : super(context,attrs)
    constructor(context:Context,attrs: AttributeSet,defStyleAttr:Int) : super(context,attrs,defStyleAttr)

    private lateinit var listener: TranslucentListener


    fun setTranslucentListener(listener: TranslucentListener) {
        this.listener = listener
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        if (::listener.isInitialized) {
            val scrollY = scrollY
            val screen_height = context.resources.displayMetrics.heightPixels
            if (scrollY < screen_height / 3f) {
                listener.onTranlucent(1 - scrollY / (screen_height / 3f)) //alpha = 滑出去的高度/(screen_height/3f)
            }
        }
    }

}
