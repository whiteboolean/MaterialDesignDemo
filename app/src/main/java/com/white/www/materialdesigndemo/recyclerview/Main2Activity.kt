package com.white.www.materialdesigndemo.recyclerview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.AdapterView
import com.white.www.materialdesigndemo.R
import com.white.www.materialdesigndemo.util.toast

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

/**
 * RecyclerView
 */
class Main2Activity : AppCompatActivity() {

    private var isGrid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //添加假数据
        val list = mutableListOf<String>()
        for (i in 1..100) {
            list.add("第${i}条")
        }
        //默认垂直布局 类似ListView
//        rcv.layoutManager  = LinearLayoutManager(this)
        //水平布局 从右往左滑
//        rcv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //水平布局，从左往右滑
//        rcv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)


        //GridView布局 三列
//        rcv.layoutManager = GridLayoutManager(this,3)

        //瀑布流
        rcv.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val adapter = RecyclerViewAdapter(list)
        rcv.adapter = adapter
        srl.setOnRefreshListener {
            adapter.notifyDataSetChanged()
            srl.isRefreshing = false
        }

        btn_change.setOnClickListener {
            if(isGrid){
                rcv.layoutManager = LinearLayoutManager(this)
            }else{
                rcv.layoutManager = GridLayoutManager(this,3)
            }
            isGrid = !isGrid
        }

        btn_add.setOnClickListener{
            adapter.addItem(2)
        }

        btn_remove.setOnClickListener {
            adapter.remove(2)
        }

        adapter.setOnItemClickListener(object : RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                toast("点击了第${position + 1}条")
            }


        })
    }

}
