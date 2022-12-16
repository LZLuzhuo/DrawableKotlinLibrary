package me.luzhuo.lib_drawable_ktx

import android.content.res.ColorStateList
import android.util.SparseIntArray
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import me.luzhuo.lib_core.app.color.ColorManager
import me.luzhuo.lib_drawable_ktx.DrawableBuilder.Companion.getColor

/**
 * 创建时间 2019/1/4
 * 描述    字体颜色构建器
 */
class ColorStateListBuilder constructor(@param:ColorInt private val mNormalColor: Int) {

    private val array = SparseIntArray()

    /**
     * 设置按下的颜色
     *
     * @param color 按下的颜色id
     */
    fun pressed(@ColorInt color: Int): ColorStateListBuilder {
        val pressed = android.R.attr.state_pressed
        array.put(pressed, color)
        return this
    }

    fun pressedRes(@ColorRes colorId: Int): ColorStateListBuilder {
        return pressed(getColor(colorId))
    }

    /**
     * 设置不可用时的颜色
     *
     * @param color 不可用的颜色id
     */
    fun unable(@ColorInt color: Int): ColorStateListBuilder {
        val unable = -android.R.attr.state_enabled
        array.put(unable, color)
        return this
    }

    fun unableRes(@ColorRes colorId: Int): ColorStateListBuilder {
        return unable(getColor(colorId))
    }

    /**
     * 设置选中时的颜色
     *
     * @param color 选中的颜色id
     */
    fun selected(@ColorInt color: Int): ColorStateListBuilder {
        val selected = android.R.attr.state_selected
        array.put(selected, color)
        return this
    }

    fun selectedRes(@ColorRes colorId: Int): ColorStateListBuilder {
        return selected(ColorManager().getColor(colorId))
    }

    /**
     * 设置checkbox中被选中时的颜色
     *
     * @param color 选中的颜色id
     */
    fun checked(@ColorInt color: Int): ColorStateListBuilder {
        val checked = android.R.attr.state_checked
        array.put(checked, color)
        return this
    }

    fun checkedRes(@ColorRes colorId: Int): ColorStateListBuilder {
        return checked(getColor(colorId))
    }

    fun build(): ColorStateList {
        val size = array.size() + 1
        val color = IntArray(size)
        val colorState = arrayOfNulls<IntArray>(size)
        for (x in 0 until size) {
            if (x != size - 1) {
                colorState[x] = intArrayOf(array.keyAt(x))
                color[x] = array.valueAt(x)
            } else {
                colorState[x] = intArrayOf()
                color[x] = mNormalColor
            }
        }
        return ColorStateList(colorState, color)
    }

    companion object {
        /**
         * 正常显示的颜色
         *
         * @param colorId 颜色id
         */
        fun normal(@ColorInt color: Int): ColorStateListBuilder {
            return ColorStateListBuilder(color)
        }
    }
}