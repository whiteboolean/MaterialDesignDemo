package com.white.www.materialdesigndemo.itemtouchhelper

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.content_main2.*
import android.support.v7.widget.DividerItemDecoration



/**
 * RecyclerView的动画交互类
 *
 */

class Main3Activity : AppCompatActivity(), StartDragListener {


    private lateinit var itemTouchHelper: ItemTouchHelper
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
        val adapter = RecyclerViewAdapter(list, this)
        rcv.adapter = adapter
        rcv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))



        //条目触摸帮助类
        val callBack = MyItemTouchHelperCallBack(adapter)
        itemTouchHelper = ItemTouchHelper(callBack)
        itemTouchHelper.attachToRecyclerView(rcv)
//        itemTouchHelper.startDrag(viewHolder)
    }


    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }


    inner class MyItemTouchHelperCallBack(private val itemTouchMoveListener: ItemMoveListener) : ItemTouchHelper.Callback() {

        /**
         * 是否打开长按拖拽的效果 return true 开启
         */
        override fun isLongPressDragEnabled(): Boolean {
            return true
        }

        /**
         * Callback回调监听时先调用的，用来判断当前是什么动作，比如判断方向（意思就是我要监听哪个方向的拖动）
         */
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
            //方向： up down left right
            //常量：
//            ItemTouchHelper.UP   1
//            ItemTouchHelper.DOWN
            //ItemTouchHelper.LEFT
            //ItemTouchHelper.UP
            //我要监听的拖拽方向是哪个两个。
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            //我要监听的swipe侧滑方向是哪个方向
//            val swipeFlags = 0
            val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT

            return makeMovementFlags(dragFlags, swipeFlags)
        }

        /**
         * 当移动的时候回调的方法 -- 拖拽
         */
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            if (viewHolder.itemViewType != target.itemViewType) {
                return false
            }
            //在拖拽的过程当中 不断地调用adapter.notifyitemchanged()
            val boolean = itemTouchMoveListener.onItemMove(viewHolder.adapterPosition, target.adapterPosition)

            return boolean
        }


        /**
         * 侧滑的时候回调的
         */
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            //监听侧滑，1.删除数据
            itemTouchMoveListener.onItemRemove(viewHolder.adapterPosition)
        }

    }

}
