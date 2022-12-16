package me.luzhuo.drawablekotlindsldemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_drawable.*
import me.luzhuo.lib_core_ktx.int
import me.luzhuo.lib_drawable_ktx.Shape

class ShapeActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ShapeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)

        // 圆角矩形
        view1.background = Shape.roundRect(0xFFFF0000.int, 10f)

        // 渐变色
        view2.background = Shape.roundRect(45, intArrayOf(0xFFFF0000.int, 0xFF00FF00.int, 0xFF0000FF.int), 10f)

        // 圆形
        view4.background = Shape.oval(0xFFFF0000.int)
    }
}