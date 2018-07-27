package com.white.www.materialdesigndemo.appbarlayout

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_my_behavior.*

class MyBehaviorActivity : AppCompatActivity() {

    private lateinit var bottomSheetDialog: BottomSheetDialog
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_behavior)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bottomSheetBehavior = BottomSheetBehavior.from(tab_layout)

        val bottomSheetDialogBehavior = BottomSheetBehavior.from(cc)

        print("状态是 ${bottomSheetBehavior.state}")

        btn_bottom_sheet_control.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
        btn_bottom_dialog_control.setOnClickListener {
            dialogShowHide()
        }

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("第${i}条")
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {

            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
            }
        })






        btn_bottom_sheet_dialog_control.setOnClickListener {
            if (bottomSheetDialogBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetDialogBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else if (bottomSheetDialogBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetDialogBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }


        createBottomSheetDialog()

    }


    private fun createBottomSheetDialog() {
        bottomSheetDialog = BottomSheetDialog(this)

        val view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_sheet, null, false)
        bottomSheetDialog.setContentView(view)

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("我是第${i}个")
        }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.isSmoothScrollbarEnabled = true
        val adapter = ListRecyclerAdapter(list)
        val rec = view.findViewById<RecyclerView>(R.id.recyclerView)

        rec.setHasFixedSize(true)
        rec.adapter = adapter
        rec.layoutManager = layoutManager
        setBehaviorCallback()

    }

    private fun setBehaviorCallback() {
        val view = bottomSheetDialog.delegate.findViewById<View>(android.support.design.R.id.design_bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from<View>(view)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetDialog.dismiss()
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }


    private fun dialogShowHide() {
        if (bottomSheetDialog.isShowing) {
            bottomSheetDialog.dismiss()
        } else {
            bottomSheetDialog.show()
        }
    }


}
