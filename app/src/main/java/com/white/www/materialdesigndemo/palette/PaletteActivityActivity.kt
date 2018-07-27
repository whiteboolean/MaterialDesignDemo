package com.white.www.materialdesigndemo.palette

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.design.R.attr.titleTextColor
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.white.www.materialdesigndemo.R

import kotlinx.android.synthetic.main.activity_palette_activity.*
import kotlinx.android.synthetic.main.content_palette_activity.*
import android.widget.Toast



class PaletteActivityActivity : AppCompatActivity() {

    private lateinit var iv: ImageView
    private lateinit var tv_title: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette_activity)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        iv = findViewById(R.id.iv)
        tv_title = findViewById(R.id.tv_title)

        val drawable = iv.drawable as BitmapDrawable
        val bitmap = drawable.bitmap

        //得到bitmap里面的一些色彩信息 ---通过Palette类分析出来的
        //Palette palette = Palette.generate(bitmap)

        //异步任务 ---可能分析的图片会比较大或者分布比较复杂，会耗时比较久，防止卡死主线程。
        Palette.from(bitmap).generate {
            //暗，柔和的颜色
            val darkMutedColor = it.getDarkMutedColor(Color.BLUE) //如果分析不出来，则返回默认颜色
            //暗，柔和
            val  lightMutedColor = it.getLightMutedColor(Color.BLUE)
            //暗，鲜艳
            val darkVibrantColor = it.getDarkVibrantColor(Color.BLUE)
            //亮，鲜艳
            val lightVibrantColor = it.getLightVibrantColor(Color.BLUE)
            //柔和
            val mutedColor = it.getMutedColor(Color.BLUE)
            //柔和
            val vibrantColor = it.getVibrantColor(Color.BLUE)

            //获取某种特性颜色的样品
            val lightVibrantSwatch = it.vibrantSwatch

            //谷歌推荐的：图片的整体颜色rgb的混合值 ---主色调
            val rgb = lightVibrantSwatch?.rgb

            //谷歌推荐：图片中间的文字颜色
            val bodyTextColor = lightVibrantSwatch?.bodyTextColor
            //颜色向量
            val hsl = lightVibrantSwatch?.hsl
            //分析改颜色在图片中所占的像素多少值
            val population = lightVibrantSwatch?.population


            tv_title.setBackgroundColor(getTranslucentColor(0.6f, rgb!!));
            tv_title.setTextColor(titleTextColor);

            tv1.setBackgroundColor(darkMutedColor);
            tv1.text = "darkMutedColor";
            tv2.setBackgroundColor(lightMutedColor);
            tv2.text = "lightMutedColor";
            tv3.setBackgroundColor(darkVibrantColor);
            tv3.text = "darkVibrantColor";
            tv4.setBackgroundColor(lightVibrantColor);
            tv4.text = "lightVibrantColor";
            tv5.setBackgroundColor(mutedColor);
            tv5.text = "mutedColor";
            tv6.setBackgroundColor(vibrantColor);
            tv6.text = "vibrantColor";
        }
    }


    /**
     * 1101 0111 1000 1011
     * 1111 1111
     * 1000 1011
     */
    private fun getTranslucentColor(percent: Float, rgb: Int): Int {
        // 10101011110001111
        val blue = Color.blue(rgb)
        val green = Color.green(rgb)
        val red = Color.red(rgb)
        var alpha = Color.alpha(rgb)
        //		int blue = rgb & 0xff;
        //		int green = rgb>>8 & 0xff;
        //		int red = rgb>>16 & 0xff;
        //		int alpha = rgb>>>24;

        alpha = Math.round(alpha * percent)
        Toast.makeText(this, "alpha:$alpha,red:$red,green:$green", Toast.LENGTH_SHORT).show()
        return Color.argb(alpha, red, green, blue)
    }

   override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}
