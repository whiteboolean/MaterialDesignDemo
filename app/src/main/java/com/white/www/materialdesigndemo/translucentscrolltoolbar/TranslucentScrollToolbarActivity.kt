package com.white.www.materialdesigndemo.translucentscrolltoolbar

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_translucent_scroll_toolbar.*

class TranslucentScrollToolbarActivity : AppCompatActivity(), TranslucentListener {
    override fun onTranlucent(alpha: Float) {
        toolbar.alpha = alpha
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translucent_scroll_toolbar)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

       val scv = findViewById<com.white.www.materialdesigndemo.translucentscrolltoolbar.MyScrollView>(R.id.scrollView)

        scv.setTranslucentListener(this)
    }

}
