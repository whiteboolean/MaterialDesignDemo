package com.white.www.materialdesigndemo.fabanimation

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.widget.ImageButton
import android.widget.Toolbar
import com.white.www.materialdesigndemo.R
import com.white.www.materialdesigndemo.parallel.com.ricky.android.percent.support.PercentFrameLayout


import kotlinx.android.synthetic.main.fab_animation.*
import android.view.animation.DecelerateInterpolator
import com.white.www.materialdesigndemo.R.id.fab
import android.support.v4.view.ViewCompat.animate
import android.R.attr.translationY
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.white.www.materialdesigndemo.R.id.toolbar



class FabAnimationActivity : AppCompatActivity(), HideScrollListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fab_animation)

//        title = "fab控件"
//
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        recyclerview.addOnScrollListener(FabScrollListener(this))
        recyclerview.layoutManager = LinearLayoutManager(this)
        val list = mutableListOf<String>()
        for (i in 0..20){
            list.add("item${i}")
        }
        val adapter = FabRecyclerAdapter(list)

        recyclerview.adapter = adapter
    }


    override fun onHide() {
        //隐藏动画
        toolbar.animate().translationY(-toolbar.height.toFloat()).interpolator = AccelerateInterpolator(3f)
        val layoutParams = fab.layoutParams as RelativeLayout.LayoutParams
        fab.animate().translationY((fab.height+layoutParams.bottomMargin).toFloat()).interpolator = AccelerateInterpolator(3f)
    }



    override fun onShow() {
        //显示动画
        toolbar.animate().translationY(0f).interpolator = DecelerateInterpolator(3f)
        fab.animate().translationY(0f).interpolator = DecelerateInterpolator(3f)
    }
}
