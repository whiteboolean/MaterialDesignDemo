package com.white.www.materialdesigndemo.util

import android.app.Activity
import android.content.Intent
import android.widget.Toast

/**
 * Author: White
 * Time:2018/7/18 13:51
 * Description: 扩展函数
 */

/**
 * 给Activity添加toast
 */
fun Activity.toast(content: String) = Toast.makeText(this, content, Toast.LENGTH_SHORT).show()

/**
 * 跳转Activity
 */
fun <T> Activity.jumpToActivity(clazz: Class<T>) = startActivity(Intent(this, clazz))
