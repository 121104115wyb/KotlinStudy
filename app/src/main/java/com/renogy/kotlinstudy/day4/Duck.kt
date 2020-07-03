package com.renogy.kotlinstudy.day4

class Duck(name: String = "鸭子", sex: Int = BirdTest.MALE) : BirdTest(name, sex) {
     override public fun getSexName(sex: Int): String {
        return if (sex == MALE) "雄性" else "雌性"
    }

}