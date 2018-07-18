package com.white.www.materialdesigndemo

import android.app.AlertDialog
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.ListPopupWindow
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import com.white.www.materialdesigndemo.util.toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSwipeLayout()
        initDialog()
        initPopupWindow()
    }


    /**
     * 初始化swipeLayout
     */
    private fun initSwipeLayout() {
        srl.setColorSchemeColors(Color.BLACK, Color.BLUE, Color.RED)
        //设置尺寸
        srl.setSize(SwipeRefreshLayout.LARGE)
        srl.setOnRefreshListener {
            Thread {
                run {
                    Thread.sleep(3000)
                    runOnUiThread {
                        srl.isRefreshing = false
                    }
                }
            }.start()
        }
        //设置进度条的背景颜色
        srl.setProgressBackgroundColorSchemeColor(Color.GREEN)
        //设置进度条的距离
        srl.setDistanceToTriggerSync(200)
    }

    /**
     * 初始化PopupWindow
     */
    private fun initPopupWindow() {
        //listPopupWindow
        val items = arrayListOf("条目1", "条目2", "条目3", "条目4")
        btn_popup_Window.setOnClickListener {
            //布局用系统默认的布局 android.R.layout.simple_list_item_1
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
            val listPopupWindow = ListPopupWindow(this)
            listPopupWindow.setAdapter(adapter)
            //设置锚点
            listPopupWindow.anchorView = it
            listPopupWindow.show()
            listPopupWindow.setOnItemClickListener { parent, view, position, id ->
                toast("点击了第${position}几条")
            }
        }

        //PopMenuWindow
//        val items2 = arrayListOf("条目1","条目2","条目3","条目4")
        btn_menu.setOnClickListener {
            val popupMenu = PopupMenu(this, btn_menu)
            popupMenu.menuInflater.inflate(R.menu.main, popupMenu.menu)
            popupMenu.show()
        }


    }


    /**
     * 初始化Dialog
     */
    private fun initDialog() {
        btn_dialog.setOnClickListener {
            AlertDialog
                    .Builder(this)
                    .setTitle("标题")
                    .setNegativeButton("取消", { dialog, _ -> dialog.dismiss() })
                    .setPositiveButton("确定", { dialog, _ -> dialog.dismiss() })
                    .create().show()
        }

    }

}
