package com.renogy.kotlinstudy.day1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.renogy.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_test_data_type.*
import org.jetbrains.anko.toast

/**
 * 学习Kotlin的基本数据类型，数组的创建和遍历
 */
class TestDataType : AppCompatActivity() {

    var data1: Int = 0;
    var TAG = "TestDataType";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_data_type)
        testDataType()

        //按钮点击事件
        arrayEach.setOnClickListener {
            testArray()
        }
    }

    /**
     * 测试基本数据类型
     */
    fun testDataType() {
        if (data1 > 10) {
//            toast("大于10可以吹牛")
            Log.d(TAG, "大于10可以吹牛")
        } else {
//            toast("小于10不能吹牛")
            Log.d(TAG, "小于10不能吹牛")
        }

        var stringBuffer = StringBuffer()

        var myfloat: Float = 100.65f
        stringBuffer.append("100.65f 转换为其它类型的数的结果")
        stringBuffer.append("\ntoString:  " + myfloat.toString())
        stringBuffer.append("\ntoDouble:  " + myfloat.toDouble())
        stringBuffer.append("\ntoLong:  " + myfloat.toLong())
        stringBuffer.append("\ntoInt:   " + myfloat.toInt())
        stringBuffer.append("\ntoChar:   " + myfloat.toChar())
        showData.text = stringBuffer.toString()
    }

    fun testArray() {
        var long_array: LongArray = longArrayOf(1, 2, 3)
        var boolean_array: BooleanArray = booleanArrayOf(true, false, false)
        var double_array: DoubleArray = doubleArrayOf(1.0, 2.1, 3.3)
        var char_array: CharArray = charArrayOf('a', 'b', 'c')
        var float_array: FloatArray = floatArrayOf(1.2f, 2.2f, 1.3f)
        val string_array: Array<String> = arrayOf("hello", "world", "Tom！！")

        var long_array1: Array<Long> = arrayOf(4, 5, 6)
        var boolean_array1: Array<Boolean> = arrayOf(false, false, false)
        //遍历字符串数组
        var resultStr: String = ""
        var index: Int = 0

        while (index < string_array.size) {
            //可以使用get方法，也可以直接引用下标
            resultStr += string_array[index] + ","
//            resultStr += string_array.get(index) + ","
            index++
        }
        toast("得到的结果为：" + resultStr)
        Log.d(TAG, "得到的结果为：" + resultStr)
    }




}