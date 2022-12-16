package me.luzhuo.drawablekotlindsldemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createDrawable(view: View) {
        DrawableActivity.start(this)
    }
    fun ShapeCreateDrawable(view: View) {
        ShapeActivity.start(this)
    }
}