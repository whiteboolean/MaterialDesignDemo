package com.white.www.materialdesigndemo.itemtouchhelper

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.content_main2.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        rcv.layoutManager = LinearLayoutManager(this)

        val list = mutableListOf<String>()
        for (i in 0..100) {
            list.add("第${i}条")
        }

        val adapter = RecyclerViewAdapter(list)
        rcv.adapter = adapter

    }

}
