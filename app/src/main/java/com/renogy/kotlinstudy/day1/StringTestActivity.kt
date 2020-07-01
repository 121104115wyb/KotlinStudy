package com.renogy.kotlinstudy.day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.renogy.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_string_test.*
import org.jetbrains.anko.longToast

class StringTestActivity : AppCompatActivity() {
    val str: String = "100"
    val boolean_str: String = "false"
    val methodStr: String = "hello;world;12345;67890"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string_test)
        initViews()
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
            Log.d("StringMethod", "str_array 数组长度：" + str_array.size.toString())
            Log.d("StringMethod", "截取5到10：" + methodStr.substring(5,10))
            Log.d("StringMethod", "第一次出现；（分号）的位置：" + methodStr.indexOf(";"))
            Log.d("StringMethod", "获取第15位的数值：" + methodStr.get(15).toString())
        }

    }


}