package com.white.www.materialdesigndemo.chenjin.design

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_chenjin_shi.*

class ChenjinShiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //设置状态栏的透明属性
        window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN) //全屏

        setContentView(R.layout.activity_chenjin_shi)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //5.0+ 可以直接用API来修改状态栏的颜色
        window?.statusBarColor = resources.getColor(R.color.colorAccent)

        //4.4 API （低于4.4可以使用）



    }

}
