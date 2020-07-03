package com.renogy.kotlinstudy.day2

import android.util.Log

class ReviewCode {

    var string_array: Array<String> = arrayOf("盖伦", "德玛西亚", "德邦总管", "赵信", "德玛西亚皇子")
    var float_array: FloatArray = floatArrayOf(12.3f, 12.2f)
    var double_array: DoubleArray = doubleArrayOf(12.3, 222.2)
    var int_Array = intArrayOf(12, 1212, 41413)

    //数组创建的三种方法
    var boolean_array = booleanArrayOf(true, false, false, false, true)
    var boolean_array1: BooleanArray = booleanArrayOf(true)
    var boolean_array3: Array<Boolean> = arrayOf(true, false, false, true)
    var boolean_array2: Array<Any> = arrayOf(true, false, "jssf")

    //集合
    var set: Set<String> = setOf("11313", "13141", "我是set")
    var mutableSet: MutableSet<String> = mutableSetOf("11313", "13141", "我是set")

    //list集合
    var list = listOf<String>("12", "22", "33")
    var mutalist = mutableListOf<String>("12", "22", "33")
    val TAG = "loopTest"

    //循环遍历
    fun testLoop() {
        for (index in mutalist.indices) {
            Log.d(TAG, mutalist[index])
        }

        for (item in mutalist) {
            Log.d(TAG, "我是forin 遍历 $item")
        }

        mutalist.forEach {
            Log.d(TAG, "我是forEach遍历 $it")
        }

        var iterator = mutalist.iterator()
        while (iterator.hasNext()) {
            var desc = iterator.next()
            Log.d(TAG, "我是迭代器遍历 $desc")
        }

        var index = 0
        while (index < mutalist.size) {
            Log.d(TAG, "我是While 遍历 ${mutalist.get(index)}")
            index++
        }

        var switchTest = arrayOf("天苍苍野茫茫", "风吹草地见牛羊")
        switchTest.forEach {
            var item = ""
            var i = 0
            while (i < it.length) {
                item = when (it.get(i).toString()) {
                    "天" -> "dddddddddddd"
                    "野" -> "哈哈哈哈"
                    "风" -> "牛羊牛羊牛羊"
                    else -> "ffffffffff"
                }
                i++
                Log.d(TAG, "我是$item")
            }
        }
    }
}