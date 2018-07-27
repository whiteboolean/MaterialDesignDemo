package com.white.www.materialdesigndemo.parallel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class MyScrollView extends HorizontalScrollView {

	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return true;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return true;
	}

}
