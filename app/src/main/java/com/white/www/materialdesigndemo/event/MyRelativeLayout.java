package com.white.www.materialdesigndemo.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Author: White
 * Time:2018/8/2 20:34
 * Description:
 *
 * action: 0 为 down
 */

public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("white","dispatchTouchEvent:action--"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }


    /**
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("white","onInterceptTouchEvent:action--"+ev.getAction());
        //默认是不拦截 返回false
        // 如果你这里直接返回true，表示拦截，那么触摸这个父布局里面的子控件时，则收不到触摸事件
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("white","onTouchEvent:action--");
        return super.onTouchEvent(event);
    }




}
