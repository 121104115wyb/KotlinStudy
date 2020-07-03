package com.renogy.kotlinstudy.day4

/**
 * 动物测试
 */
open class WildAnimalCompanion @JvmOverloads constructor(
    var name: String,
    var sex: Int,
    var tag: String = "test"
) {

    var sexName = ""

    init {
        sexName = if (sex == 0) "公的" else "母的"
    }

    fun getDesc(tag: String): String {
        return "欢迎来到$tag :这个动物名字:$name ,性别：$sexName"
    }

    companion object WildAnimalCompanion {

        val MALE = 0
        val FEMALE = 1
        val UNKNOWN = 2
        fun judgeSex(sexName: String): Int {
            return when (sexName) {
                "公的", "雄", "男" -> MALE
                "母", "女", "磁" -> FEMALE
                else -> UNKNOWN
            }
        }
    }

}