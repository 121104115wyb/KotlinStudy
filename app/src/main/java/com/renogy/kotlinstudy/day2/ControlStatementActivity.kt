package com.renogy.kotlinstudy.day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.renogy.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_control_statement.*
import kotlin.math.log

/**
 * 控制语句
 */
class ControlStatementActivity : AppCompatActivity() {

    var poemArray: Array<String?> =
        arrayOf("朝辞白帝彩云间", "", "千里江陵一日还", "null", null, "两岸猿声啼不住", "轻舟已过万重山")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_statement)
        initViews()
    }

    fun initViews() {
        var is_old = true
        tv_puzzle.text = "凉风有信，秋月无边 ！打两字"
        simpleIf.setOnClickListener {
            if (is_old) {
                showSimpleIf.text = "凉风有信的谜底是 “讽”"
            } else {
                showSimpleIf.text = "秋月无边的谜底是 “二”"
            }
            is_old = !is_old
        }
        simpleIf.setOnLongClickListener {
//            showSimpleIf.text = if (is_old) {
//                "凉风有信的谜底是 “讽”"
//            } else {
//                "秋月无边的谜底是 “二”"
//            }
            showSimpleIf.text = if (is_old) "凉风有信的谜底是 “讽”" else "秋月无边的谜底是 “二”"
            is_old = !is_old
            true
        }
        var count = 0
        simpleSwitch.setOnClickListener {
            when (count) {
                0 -> showSimpleSwitch.text = "凉风有信的谜底是 “讽”"
                1 -> showSimpleSwitch.text = "秋月无边的谜底是 “二”"
                else -> showSimpleSwitch.text = "好诗，真是一首好诗"
            }
//            showSimpleSwitch.text = when (count) {
//                0 -> "凉风有信的谜底是 “讽”"
//                1 -> "秋月无边的谜底是 “二”"
//                else -> "好诗，真是一首好诗"
//            }
            count = (count + 1) % 3
        }
        var length = 0
        complexSwitch.setOnClickListener {
            showComplexSwitch.text = when (length) {
                0, 1, 2, 3, 4, 5 -> "科技城第一帅，王玉博"
                in 13..19 -> "科技城十三郎，王玉博"
                !in 6..13 -> "我就是最帅"
                else -> "最帅就是我"
            }
            length = (length + 1) % 20
        }

        var countType: Number;
        ifSwitch.setOnClickListener {
            length = (length + 1) % 3
            countType = when (length) {
                0 -> length.toDouble()
                1 -> length.toFloat()
                else -> length.toLong()
            }
            showIfSwitch.text = when (countType) {
                is Long -> "我是Long型"
                is Float -> "我是Float"
                is Double -> "我是Double"
                else -> "我是数据类型"
            }
        }
        forLoopTest.setOnClickListener {
            var poem: String = ""
            for (item in poemArray) {
                if (item.isNullOrBlank()) {
                    continue
                }
                poem = "$poem$item,\n"
            }
//            for (index in poemArray.indices) {
//                poem = "$poem${poemArray[index]}\n,"
//            }

//            poemArray.forEach {
//                poem = "$poem$it\n,"
//            }
            showForLoop.text = poem
        }

        for (i in 0 until 66) {
            Log.d("Tag", "测试第--- $i --个")
        }
        for (i in 0 until 64 step 4) {
            Log.d("Tag", "4的倍数util关键字不包括右区间-- $i --个")
        }
        for (i in 0..64 step 4) {
            Log.d("Tag", "4的倍数包括区间..关键字-- $i --个")
        }
        for (i in 49 downTo 7) {
            Log.d("Tag", "递减到7包括区间-- $i --个")
        }

        forLoopBreak.setOnClickListener {
            var h: Int = 0;
            var is_found = false
            outSide@ while (h < poemArray.size) {
                var j: Int = 0
                var item = poemArray[h].toString();
                while (j < item.length) {
                    if (item[j].toString().equals("一")) {
                        is_found = true
                        break@outSide
                    }
                    j++
                }
                h++
            }
            Log.d("lookword", if (is_found) "我找到一了 ---$h " else "我没有找到 ---$h" )
        }
    }
}

