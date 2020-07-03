package com.renogy.kotlinstudy.day4

import android.content.Context
import org.jetbrains.anko.toast

/**
 * @JvmOverloads 关键字，兼容java开发
 *  类名和构造参数放在一起
 *  其中构造参数我们只需要重写一个方法就行了
 *  使用默认值的写法，使我们能应对各种参数的传入
 *
 *  关键字：Var 的使用 使得可以通过类名.属性值获取该类的属性结果
 *
 */
class TestAnimals1 @JvmOverloads constructor(context: Context, var name: String, var sex: Int = 0) {
    var sexName: String = ""
    var animalsDesc = ""

    init {
        sexName = if (sex == 0) "男的" else "女的"
        context.toast(name + if (sex == 0) "男的" else "女的")
    }

    fun getDesc(): String {
        animalsDesc = "这个是狗腿子吴佳杰 性别：$sexName"
        return animalsDesc
    }
}