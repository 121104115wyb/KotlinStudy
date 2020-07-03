package com.renogy.kotlinstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.renogy.kotlinstudy.day1.EasyActivity
import com.renogy.kotlinstudy.day1.StringTestActivity
import com.renogy.kotlinstudy.day1.TestDataType
import com.renogy.kotlinstudy.day2.ControlStatementActivity
import com.renogy.kotlinstudy.day3.ChecNullTestActivity
import com.renogy.kotlinstudy.day4.FunctionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        eastActivity.setOnClickListener {
            startActivity(Intent(this, EasyActivity::class.java))
        }
        testDataType.setOnClickListener {
            startActivity(Intent(this, TestDataType::class.java))
        }
        stringTestData.setOnClickListener {
            startActivity(Intent(this, StringTestActivity::class.java))
        }
        controlStatement.setOnClickListener {
            startActivity(Intent(this, ControlStatementActivity::class.java))
        }
        checkNullTest.setOnClickListener {
            startActivity(Intent(this, ChecNullTestActivity::class.java))
        }
        functionTest.setOnClickListener {
            startActivity(Intent(this, FunctionActivity::class.java))
        }
    }
}

