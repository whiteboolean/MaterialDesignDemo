package com.white.www.materialdesigndemo.recyclerview

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.white.www.materialdesigndemo.R

/**
 * Author: White
 * Time:2018/7/18 14:39
 * Description:
 */

class RecyclerViewAdapter(private val list: MutableList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private val heights = mutableListOf<Int>()

    /**
     * 创建布局
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //绑定ViewHolder
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))
        //错误方式
//        return MyViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,null))
    }

    /**
     * 数据条目
     */
    override fun getItemCount(): Int = if (list.isEmpty()) 0 else list.size

    /**
     * 绑定数据
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //演示瀑布流的效果 设置不同的高度
        heights.clear()
        list.forEach {
            heights.add((Math.random() * 100 + 200).toInt())
        }

        //LayoutParams宽高报 空指针
        val params = holder.tv.layoutParams
        params.height = heights[position]
        holder.tv.setBackgroundColor(Color.rgb(100, (Math.random() * 255).toInt(), (Math.random() * 255).toInt()))
        holder.tv.text = list[position]
        holder.tv.layoutParams = params
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv = itemView.findViewById<TextView>(android.R.id.text1)
    }


}