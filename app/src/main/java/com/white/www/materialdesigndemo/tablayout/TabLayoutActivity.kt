package com.white.www.materialdesigndemo.tablayout

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_tab_layout.*
import kotlinx.android.synthetic.main.content_tab_layout.*

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private var list = mutableListOf("新闻", "科技", "娱乐", "陕西", "妹子", "大奶", "啥啥","无极剑圣","中华大波妹")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        tabLayout = findViewById(R.id.tablayout)
        val adapter = MyPagerAdapter(supportFragmentManager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab) {
                vp.setCurrentItem(tab.position, true)
            }
        })

        tabLayout.setTabsFromPagerAdapter(adapter)
        vp.adapter = adapter

        vp.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))


    }


    inner class MyPagerAdapter : FragmentPagerAdapter {
        override fun getItem(position: Int): Fragment {
            val f = NewsDetailFragment()
            val bundle = Bundle()
            bundle.putString("title", list[position])
            f.arguments = bundle
            return f
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return list[position]
        }

        override fun getCount(): Int {

            return list.size
        }

        constructor(fm: FragmentManager) : super(fm)


    }


}
