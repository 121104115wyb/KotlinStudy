package com.renogy.kotlinstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.renogy.kotlinstudy.day1.EasyActivity
import com.renogy.kotlinstudy.day1.TestDataType
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
    }
}

