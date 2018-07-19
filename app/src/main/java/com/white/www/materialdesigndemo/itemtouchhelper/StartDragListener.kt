package com.white.www.materialdesigndemo.itemtouchhelper

import android.support.v7.widget.RecyclerView

/**
 * Author: White
 * Time:2018/7/18 21:19
 * Description:
 */
interface StartDragListener {

    /**
     * 该接口用于需要主动回调拖拽效果的
     */
    fun onStartDrag(viewHolder:RecyclerView.ViewHolder)


}