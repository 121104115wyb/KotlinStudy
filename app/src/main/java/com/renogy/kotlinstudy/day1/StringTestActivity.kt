package com.renogy.kotlinstudy.day1

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.renogy.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_string_test.*
import org.jetbrains.anko.longToast

class StringTestActivity : AppCompatActivity() {
    val str: String = "100"
    val boolean_str: String = "false"
    val methodStr: String = "hello;world;12345;67890"
    val stringSplice1: String = "Renogy"
    val stringSplice2: String = "Company"
    val goodsMutSet: Set<String> = setOf("华为畅享6", "小米6", "Oppo R11", "vivo x9sss", "苹果")
    var goodMutableSet: MutableSet<String> = mutableSetOf()
    var goodMutableSet1: MutableSet<String> = mutableSetOf()
    var goodsMutableList: MutableList<String> = mutableListOf()
    var goodMutableMap: Map<String, String> =
        mutableMapOf(
            "苹果" to "iphone11",
            "华为" to "mate30",
            "小米" to "小米8",
            Pair("魅族", "魅蓝8"),
            Pair("oppo", "oppoR9s"),
            Pair("vivo", "vivox9")
        );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string_test)
        initViews()
        testList()
    }


    fun initViews() {
        StringToOther.setOnClickListener {
            var stringbuilder = StringBuilder()
            stringbuilder.append("字符串" + str + "转换成其它数据类型的结果如下")
            stringbuilder.append("\n转换成Int" + str.toInt())
            stringbuilder.append("\n转换成Long" + str.toLong())
            stringbuilder.append("\n转换成Double" + str.toDouble())
            stringbuilder.append("\n转换成Float" + str.toFloat())
            stringbuilder.append("\n转换成char" + str.toCharArray())
            stringbuilder.append("\nboolean_str 转换成 Boolean" + boolean_str.toBoolean())
            showStringToOther.text = stringbuilder.toString()
        }

        StringMethod.setOnClickListener {
            var str_array: List<String> = methodStr.split(";")
//            Log.d("StringMethod", "str_array 数组长度：" + str_array.size.toString())
//            Log.d("StringMethod", "截取5到10：" + methodStr.substring(5, 10))
//            Log.d("StringMethod", "第一次出现；（分号）的位置：" + methodStr.indexOf(";"))
//            Log.d("StringMethod", "获取第15位的数值：" + methodStr.get(15).toString())
            var stringMethodBuffer = StringBuffer()
            stringMethodBuffer.append("$stringSplice1 字符串的测试结果如下：")
            stringMethodBuffer.append("\nstr_array 数组长度：" + str_array.size.toString())
            stringMethodBuffer.append("\n截取5到10：" + methodStr.substring(5, 10))
            stringMethodBuffer.append("\n第一次出现；（分号）的位置：" + methodStr.indexOf(";"))
            stringMethodBuffer.append("\n获取第15位的数值：" + methodStr.get(15).toString())
            showStringMethodTest.text = stringMethodBuffer.toString()
        }
        //字符串拼接测试
        stringSplice.setOnClickListener {
            var stringSpliceBuffer = StringBuffer()
            stringSpliceBuffer.append(" {$stringSplice1} 和 {$stringSplice2} 字符串拼接测试结果如下：")
            stringSpliceBuffer.append("\n 拼接到一起的结果为：$stringSplice1 $stringSplice2")
            stringSpliceBuffer.append("\n $stringSplice1 的长度为：${stringSplice1.length}")
            stringSpliceBuffer.append("\n 输出 $stringSplice2 美元符号拼接：\$${stringSplice2.length}美元")
            showStringSplice.text = stringSpliceBuffer.toString()
        }
        //三种遍历方式
        setTest.setOnClickListener {
            var setbufer = StringBuffer()
            var desc = ""
            for (item in goodsMutSet) {
                desc = "$desc 名称：$item\n"
            }
            setbufer.append("for In 手机品牌有 ${goodsMutSet.size} 个，分别是：\n ${desc.trim()} \n")
            var desc1 = ""
            val iterator = goodsMutSet.iterator()

            while (iterator.hasNext()) {
                val item1 = iterator.next()
                desc1 = "$desc1 名称1：$item1\n"
            }
            setbufer.append("迭代器手机品牌有 ${goodsMutSet.size} 个，分别是：\n ${desc1.trim()} \n")
            var desc2 = ""
            goodsMutSet.forEach { desc2 = "$desc2 品牌：$it \n" }
            setbufer.append("forEach手机品牌有 ${goodsMutSet.size} 个，分别是：\n ${desc2.trim()} \n")

            goodsMutSet.forEach { goodMutableSet.add("手机品牌 $it") }
            setbufer.append("MutableSet 测试 添加数据，长度为 ${goodMutableSet.size}\n")
            var index: Int = 0
            while (index < 10) {
                goodMutableSet.add("一加手机 $index")
                index++
            }
            goodMutableSet.forEach {
                setbufer.append("MutableSet $it\n");
                goodsMutableList.add(it)
            }
            showSetTest.text = setbufer.toString()
        }
        var index: Int = 0
        while (index < 200) {
            goodMutableSet1.add("一加手机 $index")
            index++
        }
        setTest1.setOnClickListener {
            showSetTest1.text = ""
            var setbufer = StringBuffer()
            goodMutableSet1.forEach { setbufer.append("MutableSet $it\n") }
            showSetTest1.text = setbufer.toString()
        }
    }

    //测试列表
    @RequiresApi(Build.VERSION_CODES.N)
    fun testList() {
        //给列表容器添加元素
//        goodMutableSet.forEach {  }
        listTest.setOnClickListener {
            var listBuffer = StringBuffer()
            goodsMutableList.forEach { listBuffer.append("$it\n") }

            goodsMutableList.sortBy { it.length }
            for (index in goodsMutableList.indices) {
                var item = goodsMutableList[index]
                listBuffer.append("从小到大 $item \n")
            }
            goodsMutableList.sortByDescending { it.length }
            for (index in goodsMutableList.indices) {
                var item = goodsMutableList[index]
                listBuffer.append("从大到小 $item \n")
            }
            showListTest.text = listBuffer.toString()
        }
        //map测试多种遍历方式
        mapTest.setOnClickListener {
            var mapBuffer = StringBuffer()
            mapBuffer.append("for in 循环:\n")
            for (item in goodMutableMap) {
                mapBuffer.append("key: ${item.key},value:${item.value}\n")
            }
            mapBuffer.append("迭代器循环:\n")
            val interator = goodMutableMap.iterator()
            while (interator.hasNext()) {
                val item = interator.next()
                mapBuffer.append("迭代器Key：${item.key},迭代器的value：${item.value}\n")
            }
            mapBuffer.append("ForEach循环:\n")
            goodMutableMap.forEach { key, value ->
                mapBuffer.append("ForEachKey：$key,ForEachValue：$value\n")
            }
            showMapTest.text = mapBuffer.toString()
        }
    }
}