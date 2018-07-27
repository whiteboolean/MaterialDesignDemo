package com.white.www.materialdesigndemo.navigation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.white.www.materialdesigndemo.R

/**
 * 点击导航栏按钮，切换不同的Fragment
 */
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.content_navigation.*

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()

        }

        btn.setOnClickListener {
            showSnackBar()
        }


    }

    private fun showCustomToast() {
        val toast = Toast(this)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custome_toast, null)
        val tv = view.findViewById<TextView>(R.id.textView1)
        tv.text = "自定义吐司"
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }


    private fun showSnackBar() {
        //Snackbar.LENGTH_INDEFINITE 无限模式
        val snackBar = Snackbar.make(fab, "是否开启加速模式", Snackbar.LENGTH_INDEFINITE);
        snackBar.setAction("确定", { showCustomToast() })
        snackBar.setCallback(object : Snackbar.Callback() {

            override fun onDismissed(snackbar: Snackbar, event: Int) {
                showCustomToast()
                super.onDismissed(snackbar, event)
            }

            override fun onShown(snackbar: Snackbar) {
                // TODO Auto-generated method stub
                super.onShown(snackbar)
            }
        })
        snackBar.setActionTextColor(Color.RED)
        snackBar.show()
    }
}
