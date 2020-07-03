package com.renogy.kotlinstudy.day4

import android.content.Context
import org.jetbrains.anko.toast

/**
 * 测试类的构造函数
 */
class TestAnimal {

//    init {
//        println("this is TestAnimal")
//    }

    constructor(context: Context, name: String) {
        context.toast("这个名字是：$name")
    }

    constructor(context: Context, name: String, sex: String) {
        context.toast("这个名字是：$name 性别是：$sex")
    }
}