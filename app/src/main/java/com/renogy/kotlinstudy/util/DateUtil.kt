package com.renogy.kotlinstudy.util

import androidx.annotation.NonNull
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    val nowDateTime: String
        get() {
            val dateformt = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return dateformt.format(Date())
        }

    val nowDate: String
        get() {
            val dateformt = SimpleDateFormat("yyyy-MM-dd")
            return dateformt.format(Date())
        }

    val nowTime: String
        get() {
            val dateformt = SimpleDateFormat("HH:mm:ss")
            return dateformt.format(Date())
        }

    /**
     * 自定义的时间戳
     */
    fun getFormatCustomTime(@NonNull format: String = "yyyy-mm-ss hh:mm:ss"): String {
        val ft: String = format
        if (ft.isNullOrEmpty()) {
            return SimpleDateFormat("yyyy-mm-ss hh:mm:ss").format(Date())
        } else {
            return SimpleDateFormat(ft).format(Date())
        }
    }

}