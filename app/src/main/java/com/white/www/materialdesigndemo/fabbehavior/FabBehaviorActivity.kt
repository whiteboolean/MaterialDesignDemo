package com.white.www.materialdesigndemo.fabbehavior

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.white.www.materialdesigndemo.R
import com.white.www.materialdesigndemo.fabanimation.FabRecyclerAdapter
import com.white.www.materialdesigndemo.fabanimation.FabScrollListener

import kotlinx.android.synthetic.main.activity_fab_behavior.*

class FabBehaviorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fab_behavior)
        setSupportActionBar(toolbar)



//        recyclerview.addOnScrollListener(FabScrollListener(this))
        recyclerview.layoutManager = LinearLayoutManager(this)
        val list = mutableListOf<String>()
        for (i in 0..20){
            list.add("item${i}")
        }
        val adapter = FabRecyclerAdapter(list)

        recyclerview.adapter = adapter
    }

}
