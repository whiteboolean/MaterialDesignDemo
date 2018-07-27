package com.white.www.materialdesigndemo.itemtouchhelper

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.white.www.materialdesigndemo.R
import java.util.*

/**
 * Author: White
 * Time:2018/7/18 20:15
 * Description:
 */
class RecyclerViewAdapter(private val list: MutableList<String>,
                          private val dragListener: StartDragListener)
    : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(), ItemMoveListener {


    override fun onItemRemove(fromPosition: Int) {
        list.removeAt(fromPosition)
        notifyItemRemoved(fromPosition)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(list, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //这样的话就可以拿到LayoutParams false的目的是和根布局绑定
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_rec_item, parent, false))
    }

    override fun getItemCount(): Int {
        return if (list.isEmpty()) {
            0
        } else {
            list.size
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv.text = list[position]
        holder.imageView.setOnTouchListener { v, event ->
            if (event?.action == MotionEvent.ACTION_DOWN) {
                dragListener.onStartDrag(viewHolder = holder)
            }
            false
        }
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv = itemView.findViewById<TextView>(R.id.tv)
        val imageView = itemView.findViewById<ImageView>(R.id.iv)
    }


}