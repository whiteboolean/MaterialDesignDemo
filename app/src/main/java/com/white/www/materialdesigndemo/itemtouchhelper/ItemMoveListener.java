package com.white.www.materialdesigndemo.itemtouchhelper;

/**
 * Author: White
 * Time:2018/7/19 12:44
 * Description:
 */

public interface ItemMoveListener {

    /**
     * 当拖拽的时候回调</br>
     * 可以在此方法里面实现：拖拽条目并实现刷新效果
     *
     * @param fromPosition
     * @param toPosition
     * @return
     */
    boolean onItemMove(int fromPosition, int toPosition);

    /**
     * 从哪里开始滑
     * @param fromPosition
     * @return
     */
    void onItemRemove(int fromPosition);
}
