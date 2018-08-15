package com.white.www.materialdesigndemo.event

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.white.www.materialdesigndemo.R
import kotlinx.android.synthetic.main.activity_event_test.*

class EventTestActivity : AppCompatActivity(), View.OnClickListener, View.OnTouchListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_test)

        button1.setOnClickListener(this)
        layout.setOnClickListener(this)

        button1.setOnTouchListener(this)
        layout.setOnTouchListener(this)

        btn_button1.setOnTouchListener(this)
        btn_button1.setOnClickListener {
            Log.i("EventTestActivity", "onClickListener")
        }

    }


    override fun onClick(v: View?) {
        Log.i("EventTestActivity", "onClickListener：---------view:${v}")
    }


    override fun onTouch(v: View, event: MotionEvent): Boolean {
        Log.i("EventTestActivity", "onTouchListener：action---" + event.action + "-------view:" + v)
        return false

    }


}
