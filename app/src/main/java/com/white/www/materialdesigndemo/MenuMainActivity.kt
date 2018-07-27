package com.white.www.materialdesigndemo

import android.app.Activity
import android.app.NativeActivity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.white.www.materialdesigndemo.appbarlayout.MyBehaviorActivity
import com.white.www.materialdesigndemo.chenjin.design.ChenjinShiActivity
import com.white.www.materialdesigndemo.drawerlayout.Main4Activity
import com.white.www.materialdesigndemo.fabanimation.FabAnimationActivity
import com.white.www.materialdesigndemo.fabbehavior.FabBehaviorActivity
import com.white.www.materialdesigndemo.itemtouchhelper.Main3Activity
import com.white.www.materialdesigndemo.my.behavior.NestedScrollViewAct
import com.white.www.materialdesigndemo.navigation.NavigationActivity
import com.white.www.materialdesigndemo.palette.PaletteActivityActivity
import com.white.www.materialdesigndemo.recyclerview.Main2Activity
import com.white.www.materialdesigndemo.tablayout.TabLayoutActivity
import com.white.www.materialdesigndemo.textinputlayout.TextInputLayoutActivity
import com.white.www.materialdesigndemo.toolbar.ToolbarActivity
import com.white.www.materialdesigndemo.translucentscrolltoolbar.TranslucentScrollToolbarActivity
import com.white.www.materialdesigndemo.util.jumpToActivity
import kotlinx.android.synthetic.main.activity_menu_main.*

/**
 * Author: White
 * Time:2018/7/27 14:43
 * Description:主菜单
 */
class MenuMainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_main)
        setOnClickListeners()

    }

    private fun setOnClickListeners() {
        btn_md.setOnClickListener(this)
        btn_recyclerview.setOnClickListener(this)
        btn_recyclerview_item.setOnClickListener(this)
        btn_drawerToggle.setOnClickListener(this)
        btn_navigation_view.setOnClickListener(this)
        btn_TextInputLayout.setOnClickListener(this)
        btn_ToolbarActivity.setOnClickListener(this)
        btn_PaletteActivityActivity.setOnClickListener(this)
        btn_TranslucentScrollToolbarActivity.setOnClickListener(this)
        btn_TabLayoutActivity.setOnClickListener(this)
        btn_chenjinshi.setOnClickListener(this)

        btn_MyBehaviorActivity.setOnClickListener(this)
        btn_FabAnimationActivity.setOnClickListener(this)
        btn_FabBehaviorActivity.setOnClickListener(this)
        btn_MyBehaviorActivity2.setOnClickListener(this)
        btn_NestedScrollViewAct.setOnClickListener(this)

    }


    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btn_md -> jumpToActivity(MainActivity::class.java)
            R.id.btn_recyclerview ->jumpToActivity(Main2Activity::class.java)
            R.id.btn_recyclerview_item -> jumpToActivity(Main3Activity::class.java)
            R.id.btn_drawerToggle -> jumpToActivity(Main4Activity::class.java)
            R.id.btn_navigation_view -> jumpToActivity(NavigationActivity::class.java)
            R.id.btn_TextInputLayout -> jumpToActivity(TextInputLayoutActivity::class.java)
            R.id.btn_ToolbarActivity -> jumpToActivity(ToolbarActivity::class.java)
            R.id.btn_PaletteActivityActivity -> jumpToActivity(PaletteActivityActivity::class.java)
            R.id.btn_TranslucentScrollToolbarActivity ->jumpToActivity(TranslucentScrollToolbarActivity::class.java)
            R.id.btn_TabLayoutActivity ->jumpToActivity(TabLayoutActivity::class.java)
            R.id.btn_chenjinshi->jumpToActivity(ChenjinShiActivity::class.java)
            R.id.btn_MyBehaviorActivity ->jumpToActivity(MyBehaviorActivity::class.java)
            R.id.btn_FabAnimationActivity ->jumpToActivity(FabAnimationActivity::class.java)
            R.id.btn_FabBehaviorActivity ->jumpToActivity(FabBehaviorActivity::class.java)
            R.id.btn_MyBehaviorActivity2 ->jumpToActivity(com.white.www.materialdesigndemo.my.behavior.MyBehaviorActivity::class.java)
            R.id.btn_NestedScrollViewAct ->jumpToActivity(NestedScrollViewAct::class.java)
        }
    }
}