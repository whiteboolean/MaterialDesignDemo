package com.white.www.materialdesigndemo.toolbar

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.MenuItemCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.white.www.materialdesigndemo.R
import com.white.www.materialdesigndemo.util.toast

import kotlinx.android.synthetic.main.activity_toolbar.*

/**
 * 自定义SearchView的方法
 * https://www.jianshu.com/p/7c1e78e91506
 *
 */

class ToolbarActivity : AppCompatActivity() {

    private lateinit var mSearchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //至于导航返回按钮的图标，可以用过toolbar.setNavigationIcon() 方法或者 app：navigationIcon属性来修改
        toolbar.setNavigationOnClickListener {
            finish()
        }


    }

    private fun initListener() {

        /**
         * 搜索框展开时后面叉叉按钮的点击事件
         */
        mSearchView.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                Toast.makeText(applicationContext, "close", Toast.LENGTH_SHORT).show()
                return false
            }
        })


        /**
         * 搜索图标按钮（打开搜索框的按钮）的点击事件
         */
        mSearchView.setOnSearchClickListener {
            Toast.makeText(applicationContext, "open", Toast.LENGTH_SHORT).show()
        }


        /*
        搜索框文字变化监听
         */
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                    toast("输入提交")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                toast("输入文字了")
                return true
            }
        })


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu?.findItem(R.id.menu_search)
        //通过MenuItem得到Searchview
        mSearchView = MenuItemCompat.getActionView(searchItem) as SearchView

        /*------------------ SearchView有三种默认展开搜索框的设置方式，区别如下： ------------------*/
        //设置搜索框直接展开显示。左侧有放大镜(在搜索框中) 右侧有叉叉 可以关闭搜索框
//        mSearchView.isIconified = false
        //设置搜索框直接展开显示。左侧有放大镜(在搜索框外) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
//        mSearchView.setIconifiedByDefault(false)
        //设置搜索框直接展开显示。左侧有无放大镜(在搜索框中) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
        mSearchView.onActionViewExpanded()


        //Search的常规设置
        //设置最大宽度
        mSearchView.maxWidth = 500
        //设置是否显示搜索框展开时的提交按钮
        mSearchView.isSubmitButtonEnabled = true
        //设置输入框提示语
        mSearchView.queryHint = "hint"

        initListener()

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
        //点击事件 左上角返回键
            android.R.id.home -> {
                finish()
            }
            R.id.action_settings -> {
                toast("action——settings")
            }
            R.id.action_share -> {
                toast("action--share")
            }
            R.id.action_new -> {
                toast("actoin--new")
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
