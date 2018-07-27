package com.white.www.materialdesigndemo.toolbar

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.white.www.materialdesigndemo.R
import kotlinx.android.synthetic.main.activity_search_view2.*

/**
 * Author: White
 * Time:2018/7/20 14:21
 * Description:
 */
class SearchViewActivity2 : AppCompatActivity() {


    private lateinit var mSearchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view2)
        setSupportActionBar(toolbar)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_view, menu)
        val searchItem = menu?.findItem(R.id.menu_search)

        mSearchView = MenuItemCompat.getActionView(searchItem) as SearchView

        return super.onCreateOptionsMenu(menu)
    }


    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        if (menu != null) {
            if (menu.javaClass.simpleName.equals("MenuBuilder", true)) {
                try {
                    val method = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible"  ,java.lang.Boolean.TYPE)
                    method.isAccessible = true;
                    method.invoke(menu, true);
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        return super.onMenuOpened(featureId, menu)
    }


    //用来提取颜色的bitmap
    private fun getPalette(){


    }







}
