package me.luzhuo.drawablekotlindsldemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_drawable.*
import me.luzhuo.lib_core_ktx.int
import me.luzhuo.lib_drawable_ktx.*

class DrawableActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, DrawableActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)

        // 圆角矩形
        view1.background = shapeDrawable {
            shape(ShapeType.RECTANGLE)
            solid(0xFFFF0000.int)
            corner(10f)
        }

        // 渐变色
        view2.background = shapeDrawable {
            shape(ShapeType.RECTANGLE)
            gradient(45, intArrayOf(0xFFFF0000.int, 0xFF00FF00.int, 0xFF0000FF.int))
            corner(10f)
        }

        // 虚边框
        view3.background = shapeDrawable {
            shape(ShapeType.RECTANGLE)
            solid(0xFFFF0000.int)
            corner(10f)
            stroke(0xFF0000FF.int, 2f, 2f, 5f)
        }

        // 圆形
        view4.background = shapeDrawable {
            shape(ShapeType.OVAL)
            solid(0xFFFF0000.int)
        }

        // 选择器
        view5.background = selectorDrawable {
            normal = shapeDrawable {
                shape(ShapeType.RECTANGLE)
                solid(0xFFFF0000.int)
                corner(10f)
            }
            pressed = shapeDrawable {
                shape(ShapeType.RECTANGLE)
                solid(0xFF00FF00.int)
                corner(10f)
            }
        }

        // 添加内边距
        view6.background = insetDrawable {
            drawable = shapeDrawable {
                corner(10f)
                solid(0xFFFF0000.int)
            }
            setInset(10)
        }

        // 图层叠加
        view7.background = layerDrawable {
            addLayer(shapeDrawable {
                shape(ShapeType.RECTANGLE)
                solid(0xFFFF0000.int)
                corner(10f)
            })
            addLayer(insetDrawable {
                drawable = shapeDrawable {
                    shape(ShapeType.RECTANGLE)
                    solid(0xFF00FF00.int)
                    corner(10f)
                    padding(10f)
                }
                setInset(10)
            })
        }
    }
}