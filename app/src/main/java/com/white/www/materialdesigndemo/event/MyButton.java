package com.white.www.materialdesigndemo.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Author: White
 * Time:2018/8/2 16:30
 * Description:
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("myButton","dispatchTouchEvent:action--" + event.getAction());
        //super不能少 知道不？sb
        //默认情况下是true
       return  super.dispatchTouchEvent(event);
//        return false;

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("myButton","onTouchEvent:action--"+event.getAction());

        return super.onTouchEvent(event);
    }






}
