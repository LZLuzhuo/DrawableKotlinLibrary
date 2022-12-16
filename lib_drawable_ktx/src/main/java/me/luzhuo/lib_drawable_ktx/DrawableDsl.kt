package me.luzhuo.lib_drawable_ktx

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes

/**
 * 代码来源: https://github.com/forJrking/DrawableDsl
 * 开源协议: Apache License 2.0
 *
 * 对源码进行了以下修改:
 * 1. 将所有类的包名 com.github.forjrking.drawable 修改为 me.luzhuo.lib_drawable
 * 2. 修改 DrawableBuilder 类, 删除 cxt() 函数; 补充将 ResColor 转成 IntColor 的函数
 * 3. 删除 DrawableDsl.kt 文件里 infix fun ImageView.src(drawable: Drawable?) 上的 @Deprecated 注解
 * 4. 修改 DrawableDel.kt 文件里, 将 ResColor 转成 IntColor 的函数
 * 5. ColorStateListBuilder 构造默认为 ResColor 改成 IntColor
 * 6. ColorStateListBuilder 支持 IntColor
 * 7. ShapeBuilder 支持 IntColor
 * 8. ShapeBuilder 支持不限颜色数量的渐变色
 * 9. ShapeBuilder 里的 Shape 枚举名修改为 ShapeType
 * 10. 创建并编写 Shape 类
 */

/**
 * shape dsl构建方法
 * @date: 2021/4/20 2:45 PM
 */
inline fun shapeDrawable(builder: ShapeBuilder.() -> Unit): Drawable {
    return ShapeBuilder().also(builder).build()
}

/**
 * selector dsl构建方法
 * @date: 2021/4/20 2:45 PM
 */
inline fun selectorDrawable(builder: SelectorBuilder.() -> Unit): Drawable {
    return SelectorBuilder().also(builder).build()
}

/**资源*/
fun resourceDrawable(@DrawableRes resId: Int): Drawable {
    return ResourceBuilder(resId).build()
}

/**
 * InsetDrawable dsl构建方法
 * @date: 2021/4/20 2:45 PM
 */
inline fun insetDrawable(builder: InsetBuilder.() -> Unit): Drawable {
    return InsetBuilder().also(builder).build()
}

/**
 * layerDrawable dsl构建方法
 * @date: 2021/4/20 2:45 PM
 */
inline fun layerDrawable(builder: LayerListBuilder.() -> Unit): Drawable {
    return LayerListBuilder().also(builder).build()
}

/**
 * colorStateList dsl构建方法
 * @date: 2021/4/20 2:45 PM
 */
inline fun colorStateList(@ColorInt colorInt: Int, builder: ColorStateListBuilder.() -> Unit): ColorStateList {
    return ColorStateListBuilder(colorInt).also(builder).build()
}

/**为所有ImageView添加 infix函数去掉括号*/
infix fun ImageView.src(drawable: Drawable?) {
    this.setImageDrawable(drawable)
}

/**扩展函数用法*/
var ImageView.src: Drawable
    get() = drawable
    set(value) { this.setImageDrawable(value) }