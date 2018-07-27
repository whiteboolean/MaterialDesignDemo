package com.white.www.materialdesigndemo.textinputlayout

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import com.white.www.materialdesigndemo.R
import com.white.www.materialdesigndemo.util.toast

import kotlinx.android.synthetic.main.activity_text_input_layout.*
import kotlinx.android.synthetic.main.content_text_input_layout.*

class TextInputLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", {
                        toast("点击了Action")
                    }).show()
        }

        btn_login.setOnClickListener {
            val account = til_account.editText?.text.toString()
            val password = til_password.editText?.text.toString()

            til_account.isErrorEnabled = false
            til_password.isErrorEnabled =false

            if(validateAccount(account) and validatePassword(password)){
                Snackbar.make(btn_login,"登陆成功",Snackbar.LENGTH_SHORT).show()
            }
        }
    }


    /**
     * 添加一个显示错误提示并获取焦点的方法
     */
    private fun showError(textInputLayout:TextInputLayout, error:String){
        textInputLayout.error = error
        textInputLayout.editText?.isFocusable = true
        textInputLayout.editText?.isFocusableInTouchMode = true
        textInputLayout.editText?.requestFocus()
    }



    private fun validateAccount(account:String):Boolean{
        if (account.isEmpty()){
            showError(til_account,"用户名不能为空")
            return false
        }
        return true
    }

    /**
     * 添加验证用户名和密码方法
     */
    private fun validatePassword(password:String):Boolean{
        if(password.isEmpty()){
            showError(til_password,"密码不能为空")
            return false
        }

        if(password.length<6 || password.length>18){
            showError(til_password,"密码长度为6-18位")
            return false
        }
        return true
    }
}
