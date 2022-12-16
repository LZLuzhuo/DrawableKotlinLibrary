/* Copyright 2022 Luzhuo. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.luzhuo.lib_drawable_ktx

import android.graphics.drawable.Drawable

/**
 * 常用的形状
 * 用于简化 DrawableDel.kt 的操作
 */
object Shape {
    /**
     * 圆角矩形
     * @param bgColor 背景色
     * @param corner 圆角
     */
    fun roundRect(bgColor: Int, corner: Float): Drawable {
        return shapeDrawable {
            shape(ShapeType.RECTANGLE)
            solid(bgColor)
            corner(corner)
        }
    }

    fun roundRect(bgColor: Int, cornerLeftTop: Float, cornerRightTop: Float, cornerLeftBottom: Float, cornerRightBottom: Float): Drawable {
        return shapeDrawable {
            corner(cornerLeftTop, cornerRightTop, cornerLeftBottom, cornerRightBottom)
            solid(bgColor)
        }
    }

    /**
     * 圆角矩形
     * @param bgColor 背景色
     * @param corner 圆角
     * @param strokeColor 边框颜色
     * @param strokeWidth 边框宽度
     */
    fun roundRect(bgColor: Int, corner: Float, strokeColor: Int, strokeWidth: Float): Drawable {
        return shapeDrawable {
            shape(ShapeType.RECTANGLE)
            solid(bgColor)
            corner(corner)
            stroke(strokeColor, strokeWidth)
        }
    }

    /**
     * 圆角矩形
     * @param bgColor 背景色
     * @param corner 圆角
     * @param strokeColor 边框颜色
     * @param strokeWidth 边框宽度
     * @param dashGap 虚线间隙
     * @param dashWidth 虚线宽度
     */
    fun roundRect(bgColor: Int, corner: Float, strokeColor: Int, strokeWidth: Float, dashGap:Float, dashWidth:Float): Drawable {
        return shapeDrawable {
            shape(ShapeType.RECTANGLE)
            solid(bgColor)
            corner(corner)
            stroke(strokeColor, strokeWidth, dashGap, dashWidth)
        }
    }

    /**
     * 渐变圆角矩形
     * @param colorAngle 渐变角度
     * @param bgColor 渐变数组
     * @param corner 圆角
     */
    fun roundRect(colorAngle: Int, bgColor: IntArray, corner: Float): Drawable {
        return shapeDrawable {
            shape(ShapeType.RECTANGLE)
            gradient(colorAngle, bgColor)
            corner(corner)
        }
    }

    fun roundRect(colorAngle: Int, bgColor: IntArray, cornerLeftTop: Float, cornerRightTop: Float, cornerLeftBottom: Float, cornerRightBottom: Float): Drawable {
        return shapeDrawable {
            shape(ShapeType.RECTANGLE)
            gradient(colorAngle, bgColor)
            corner(cornerLeftTop, cornerRightTop, cornerLeftBottom, cornerRightBottom)
        }
    }

    /**
     * 圆形
     */
    fun oval(bgColor: Int): Drawable {
        return shapeDrawable {
            shape(ShapeType.OVAL)
            solid(bgColor)
        }
    }

    /**
     * 圆形
     * @param bgColor 背景色
     * @param strokeColor 边框颜色
     * @param strokeWidth 边框宽度
     */
    fun oval(bgColor: Int, strokeColor: Int, strokeWidth: Float): Drawable {
        return shapeDrawable {
            shape(ShapeType.OVAL)
            solid(bgColor)
            stroke(strokeColor, strokeWidth)
        }
    }
}