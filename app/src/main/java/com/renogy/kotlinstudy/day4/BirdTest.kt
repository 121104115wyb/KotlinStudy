package com.renogy.kotlinstudy.day4

open class BirdTest @JvmOverloads constructor(var name: String, var sex: Int = 0) {

    private var sexName = ""

    init {
        sexName = if (sex == 0) "公" else "母"

    }

    //必须new 出来才能调用
    open protected fun getSexName(sex: Int): String {
        return if (sex == MALE) "公" else "母"
    }

    //必须new 出来才能调用
    fun getDesc(): String {
        return "这是一段毫无营养的话"
    }

    //类似java的静态方法直接使用类名.方法名
    companion object BirdTest {
        //只能用app的内部，防止其他的app调用
        internal val MALE = 0
        public val FEMALE = 1
        private val UNKNOWN = 2
        fun getSexInt(sexName: String): Int {
            return when (sexName) {
                "公" -> MALE
                "母" -> FEMALE
                else -> UNKNOWN
            }
        }

    }

}