package com.renogy.kotlinstudy.day3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.renogy.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_check_null_test.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * Kotlin 非空校验
 */
class ChecNullTestActivity : AppCompatActivity() {
    var stringTest = "renogyCompany"
    val TAG = "StirngTest"

    var strNotNull: String = ""
    var strCanNull: String? = null
    var strCanNull1: String? = "null"
    var str_name = "test"
    var str_name1 = "Test"
    var strInTestArray: Array<String> = arrayOf("monkey", "apple", "banana", "orange")
    var strInItem = "apple"
    var strInItem1 = "watermelon"
    var isInArray = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_null_test)
        initData()
    }

    /**
     * 校验非空数据
     */
    fun initData() {
        if (stringTest.isEmpty()) {
            Log.e(TAG, "字符串是空或者长度为0")
        }
        if (stringTest.isBlank()) {
            Log.e(TAG, "字符串长度为0或者都是空格")
        }
        //强制不进行非空校验，因为kotlin代码编译时会强制进行非空校验，使用！！就是不进行非空校验
        //kotlin 非空校验符，就是一个鸡肋，还不是要自己写非空校验，垃圾
//        Log.e(TAG, "strCanNull 的字符串长度为 ${strCanNull!!.length}")
        var str_length: Int?
        checkNull.setOnClickListener {
//            str_length = strCanNull?.length
//            toast("使用？.得到字符串的长度为 $str_length")

//            str_length = strCanNull?.length ?: -1
//            toast("使用？. ?:得到字符串的长度为 $str_length")

//            try {
//                str_length = strCanNull!!.length
//                toast("使用？. ?:得到字符串的长度为 $str_length")
//            } catch (e: Exception) {
//                toast("使用？. ?:得到字符串的长度为 发现空指针")
//            }

            if (strCanNull.isNullOrEmpty()) {
                toast("strCanNull 为空或者长度为0")
            } else {
                toast("strCanNull 的长度 ${strCanNull!!.length}")
            }
        }

        equalTest.setOnClickListener {
            if (str_name == str_name1) {
                toast("$str_name 和 $str_name1 比较相等")
            } else {
                toast("$str_name 和 $str_name1 比较不相等")
            }
        }

        val date1: Date = Date()
        val date2: Any = date1.clone()
        var count = 0
        addressTest.setOnClickListener {
            showAddressTest.text = when (count++ % 4) {
                0 -> "使用 == 比较date和date1的结果：${date1 == date2}"
                1 -> "使用 ！= 比较date和date1的结果：${date1 != date2}"
                2 -> "使用 === 比较date和date1的结果：${date1 === date2}"
                else -> "使用 !== 比较date和date1的结果：${date1 !== date2}"
            }
        }

        isTest.setOnClickListener {
            showIsTest.text = when (addressTest) {
                is Button -> "addressTest 是button"
                is View -> "addressTest 也是View"
                is ImageView -> "addressTest 不是ImageView"
                else -> "addressTest 到底是什么"
            }
        }

        inTest.setOnClickListener {
            if (isInArray) {
                showInTest.text = when (strInItem) {
                    in strInTestArray -> "$strInItem 在 strInTestArray 里面 "
                    else -> "$strInItem 不在 strInTestArray 里面 "
                }
            } else {
                showInTest.text = when (strInItem1) {
                    in strInTestArray -> "$strInItem1 在 strInTestArray 里面 "
                    else -> "$strInItem1 不在 strInTestArray 里面 "
                }
            }
            isInArray = !isInArray
        }

        funTest.setOnClickListener {
            makeFood(12, null, 2.5)
            toast(makeFoodTest(12, "123", 3.4, 15f))
        }

        funParmsTest.setOnClickListener {
            showFunParmsTest.text = fourBigDefault("古代四大发明", "唐代开始使用的火药")
        }
        funParmsArrayTest.setOnClickListener {
            showFunParmsArrayTest.text =
                fourBigVararg(arrayOf("瓷器", "国画"), arrayOf("茶叶", "丝绸"), arrayOf("支付", "共享单车"))
        }

        var intArray: IntArray = intArrayOf(1, 2, 3)
        var doubleArray: DoubleArray = doubleArrayOf(1.2, 3.3, 2.1)
        var intArray1: Array<Int> = arrayOf(1, 2, 3)
        funTTest.setOnClickListener {
            showfunTTest.text =
                "${appendString<String>("这个泛型参数设置", "德玛西亚", "德玛西亚皇子")}\n 其它类型测试：\n" +
                        "${appendString<Int>("这个泛型参数设置", 123, 789)}"
            //输入intArray或者doubleArray编译报错
//            setArrayNumber(intArray)
//            setArrayNumber(doubleArray)
            //直接新建array是可以的
            var testStr = setArrayNumber(arrayOf(1, 2, 3, 4.5))
            Log.d("testStr", "测试这个对不对：$testStr")

            var testStr1 = setArrayStr<Int>(intArray1)
            Log.d("testStr", "测试这个：$testStr1")
            var result = factorial(8)
            toast("8的阶乘结果为：$result")

        }

        compareTest.setOnClickListener {
            var result = compare<String>(compare_array) { a, b -> a.length > b.length }

            toast("比较大小：$result")

            var resultDouble = findFixPoint(30.9)
            toast("findFixPoint：$resultDouble")
        }
    }

    /**
     * @param eggs 几个鸡蛋
     * @param water 几瓢水,后面带问号，表示值可以为空
     * @param leek 几把韭菜
     */
    fun makeFood(eggs: Int, water: String?, leek: Double) {
        showFunTest.text = "$eggs 个鸡蛋，$water 瓢水，$leek 把韭菜"
    }

    /**
     * @param eggs 几个鸡蛋
     * @param water 几瓢水,后面带问号，表示值可以为空
     * @param leek 几把韭菜
     * return 做饭的所有食材
     */
    fun makeFoodTest(eggs: Int, water: String?, leek: Double, meat: Float): String {
        return "$eggs 个鸡蛋，$water 瓢水，$leek 把韭菜, $meat 斤牛肉"
    }

    /**
     * 四大发明
     */
    fun fourBigDefault(
        general: String = "古代四大发明",
        first: String = "火药",
        second: String = "指南针",
        third: String = "印刷术",
        four: String = "造纸术"
    ): String {
        return "$general 分别是: $first,$second,$third,$four"
    }


    /**
     * 四大发明，可变参数
     */
    fun fourBigVararg(vararg other: String?): String {
        var desc = ""
        for (item in other) {
            desc = "$desc $item;"
        }
        return desc
    }

    /**
     * 四大发明，可变参数
     */
    fun fourBigVararg(vararg otherArray: Array<String>): String {
        var desc = ""
        for (itemArray in otherArray) {
            itemArray.forEach {
                desc = "$desc $it;"
            }
        }
        return desc
    }

    /**
     * 测试泛型参数
     */
    fun <T> appendString(tag: String, vararg otherString: T?): String {
        var desc = "$tag:\n"
        for (item in otherString) {
            desc = "$desc ${item.toString()}"
        }
        return desc
    }

    /**
     * 测试array<Number>
     */
    fun setArrayNumber(array: Array<Number>): String {
        var desc = ""
        array.forEach {
            desc = "$desc $it"
        }
        return desc
    }

    private inline fun <reified T : Number> setArrayStr(array: Array<T>): String {
        var str: String = "数组元素排列：\n"
        array.forEach {
            str = "$str$it,"
        }
        Log.e("setArrayStr", "结果为：$str")
        return str
    }


    fun factorial(n: Int): Int {
        return if (n <= 1) n else n * factorial(n - 1)
    }


    var compare_array: Array<String> = arrayOf("how", "are", "welcome", "china", "American")
    fun <T> compare(array: Array<T>, greater: (T, T) -> Boolean): T? {
        var max: T? = null
        array.forEach {
            if (max == null || greater(it, max!!)) {
                max = it
            }
        }

//        for (item in array) {
//            if (max == null || greater(item, max))
//                max = item
//        }
        return max
    }

    private tailrec fun findFixPoint(x: Double = 1.0): Double =
        if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))


}