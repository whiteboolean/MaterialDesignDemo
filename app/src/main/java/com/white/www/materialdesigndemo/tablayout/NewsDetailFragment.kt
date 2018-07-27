package com.white.www.materialdesigndemo.tablayout

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Author: White
 * Time:2018/7/21 19:52
 * Description:
 */
class NewsDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val tv = TextView(context)
        val bundle = arguments
        val title=bundle?.getString("title")
        tv.text = title
        tv.gravity = Gravity.CENTER
        tv.setBackgroundColor(Color.rgb((Math.random()*255).toInt(),(Math.random()*255).toInt(),(Math.random()*255).toInt()))



        return tv
    }
}