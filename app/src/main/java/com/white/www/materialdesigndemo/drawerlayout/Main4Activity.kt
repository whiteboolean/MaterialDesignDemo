package com.white.www.materialdesigndemo.drawerlayout

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.content_main4.*



class Main4Activity : AppCompatActivity() {

    //抽屉菜单对象
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initLayout()
        initEvent()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }


    private fun initLayout() {
        //设置菜单内容之外其他区域的背景颜色
        main_drawer_layout.setScrimColor(Color.TRANSPARENT)
    }


    private fun initEvent() {

        //同步状态
//        drawerToggle.syncState()
         drawerToggle = ActionBarDrawerToggle(this, main_drawer_layout, toolbar, R.string.open, R.string.close)
        //同步状态
        drawerToggle.syncState()

        //设置左上角的图标按钮 动画效果
//        main_drawer_layout.setDrawerListener(drawerToggle)

        main_drawer_layout.setDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
                //状态发生改变
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                //滑动过程中不断的回调 slideOffset: 0~1
//                val content = main_drawer_layout.getChildAt(0)
//                val menu = drawerView
//                val scale = 1 - slideOffset
//                val leftScale = (1 - 0.3*scale).toFloat()
//                val rightScale = (0.7f+0.3*scale).toFloat()
//                menu.scaleX = leftScale
//                menu.scaleY = leftScale
//
//                content.scaleX = rightScale
//                content.scaleX = rightScale
//                content.translationX = menu.measuredWidth * (1-scale)
            }

            override fun onDrawerClosed(drawerView: View) {
            }

            override fun onDrawerOpened(drawerView: View) {}

        })

//        drawerToggle = object : ActionBarDrawerToggle(this, main_drawer_layout,toolbar, R.string.open, R.string.close) {
//            //菜单打开
//            override fun onDrawerOpened(drawerView: View) {
//                super.onDrawerOpened(drawerView)
//            }
//
//            // 菜单关闭
//            override fun onDrawerClosed(drawerView: View) {
//                super.onDrawerClosed(drawerView)
//            }
//        }

//        main_drawer_layout.setDrawerListener()


        btn_left.setOnClickListener {
            if (main_drawer_layout.isDrawerOpen(main_left_drawer_layout)) {
                main_drawer_layout.closeDrawer(main_left_drawer_layout)
            } else {
                main_drawer_layout.openDrawer(main_left_drawer_layout)
            }
        }


        btn_right.setOnClickListener {
            if (main_drawer_layout.isDrawerOpen(main_right_drawer_layout)) {
                main_drawer_layout.closeDrawer(main_right_drawer_layout)
            } else {
                main_drawer_layout.openDrawer(main_right_drawer_layout)
            }
        }
    }

}
