package com.renogy.kotlinstudy.day4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.renogy.kotlinstudy.R
import com.renogy.kotlinstudy.util.DateUtil
import kotlinx.android.synthetic.main.activity_function.*
import org.jetbrains.anko.toast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * 高阶函数测试
 */
class FunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)
        testFunction()
    }


    /**
     * 测试高阶函数
     */
    var array: Array<String> = arrayOf("123", "23", "33333", "4444", "5666666")
    var array_double: Array<Double> = arrayOf(1.1, 2.2, 3.3, 5.6, 6.6, 7.7)

    fun testFunction() {
        highFunction.setOnClickListener {
            array_double.swap(1, 3)
            var desc = "结果为：\n"
            array_double.forEach {
                desc = "$desc \n $it"
            }
            showHighFunction.text = desc

            var arrayResult = array.maxCustomize { a, b -> a.length > b.length }
            Log.e("arrayResult", "arrayResult : $arrayResult")

            var arrayDoubleResult = array_double.maxCustomize { a, b -> a.toInt() > b.toInt() }
            Log.e("arrayDoubleResult", "arrayDoubleResult : $arrayDoubleResult")

        }

        dateFunction.setOnClickListener {
            showDateFunction.text = "getInstanceDate: ${Date().getNowDateTime()}"
        }

        UtilTest.setOnClickListener {
            showUtilTest.text = getTotalTime()
        }
        var boolean_one = true
        testConstructor.setOnClickListener {
            if (boolean_one) {
//                TestAnimals1(this,"吴佳杰")
                TestAnimal(this, "大黄")
            } else {
//                TestAnimals1(this,"吴佳杰",1)
                TestAnimal(this, "大黄", "雌性")
            }
            boolean_one = !boolean_one
        }
        //测试属性
        testConstructorAttributes.setOnClickListener {
//            var testAnimal = TestAnimals1(this, "吴佳杰", 1)
//            toast("testAnimal :名称：${testAnimal.name} 性别：${testAnimal.sex} ${testAnimal.sexName} ${testAnimal.getDesc()}")
            testStatic()
        }
        var count = 0
        //测试类的继承
        testFunctionExtend.setOnClickListener {
            var sexResult = if (count++ % 3 == 0) BirdTest.MALE else BirdTest.FEMALE
            var duck = Duck(sex = sexResult)
            toast("名字：${duck.name} 性别：${duck.getSexName(1)}")
        }


    }

    /**
     * 数据位置交换
     *
     */
    fun Array<Int>.swap(pos1: Int, pos2: Int) {
        val temp = this[pos1]
        this[pos1] = this[pos2]
        this[pos2] = temp
    }

    /**
     * 数据位置交换
     */
    fun <T> Array<T>.swap(pos1: Int, pos2: Int) {
        if (pos1 >= this.size || pos2 >= this.size) {
            toast("数组越界")
        } else {
            val temp = this[pos1]
            this[pos1] = this[pos2]
            this[pos2] = temp
        }
    }

    /**
     * 扩展Array 比较大小函数
     * 返回最大值
     * 这不就是冒泡排序吗
     */
    fun <T> Array<T>.maxCustomize(greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in this)
            if (max == null || greater(item, max)) {
                max = item
            }
        return max
    }

    fun Date.getNowDateTime(): String {
        val date = Date()


        val locale = Locale("zh", "CN");

        // 等价于 DateFormat.getDateTimeInstance( DateFormat.MEDIUM);
        val short0 = SimpleDateFormat.getDateTimeInstance();

        val short1 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        val medium1 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        val long1 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        val full1 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

        val short2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
        val medium2 =
            DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        val long2 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        val full2 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);

        return "short0: ${short0.format(date)}\n short1:${short1.format(date)}\n medium1:${medium1.format(
            date
        )}\nlong1:${long1.format(date)}" +
                "\n full1:${full1.format(date)}\nshort2:${short2.format(date)}\nmedium2: ${medium2.format(
                    date
                )}"
    }


    fun getTotalTime(): String {
        return "nowDate:${DateUtil.nowDate}\n nowDateTime:${DateUtil.nowDateTime}\n nowTime:${DateUtil.nowTime}\n getFormatCustomTime:${DateUtil.getFormatCustomTime()}"
    }

    //测试kotlin的静态方法类似于java的static
    fun testStatic() {
        var wildResult = WildAnimalCompanion.judgeSex("公的")
        toast("判断公的还是母的表示的数字：$wildResult")
    }

}