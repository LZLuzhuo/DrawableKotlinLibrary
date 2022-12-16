package me.luzhuo.lib_drawable_ktx

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import me.luzhuo.lib_core.app.base.CoreBaseApplication


interface DrawableBuilder {
    /**
     * 此方法构建出新的Drawable给控件设置背景
     *
     * @return 构造好的Drawable
     */
    fun build(): Drawable?

    companion object {
        /**
         * 将 ResColor 转成 IntColor
         */
        @ColorInt
        fun getColor(@ColorRes colorId: Int): Int {
            return ContextCompat.getColor(CoreBaseApplication.appContext, colorId)
        }

        /**
         * Value of dp to value of px.
         * @param dpValue The value of dp.
         * @return value of px
         */
        internal fun dp2px(dpValue: Float): Float {
            val scale = CoreBaseApplication.appContext.resources.displayMetrics.density
            return dpValue * scale
        }
    }
}