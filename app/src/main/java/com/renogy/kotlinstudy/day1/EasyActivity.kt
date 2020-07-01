package com.renogy.kotlinstudy.day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.renogy.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_easy.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class EasyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)
        initViews()
    }


    fun initViews() {
        button.text = "德玛西亚"
        showInput.text = getString(R.string.text_showinput_default)
        button.setOnClickListener {
            showInput.text = inputEdit.text
            toast("click me")
//            Toast.makeText(, "", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this, "click me", Toast.LENGTH_SHORT).show()
        }

        button.setOnLongClickListener {
            longToast("click long me");true
//            Toast.makeText(this, "click long me", Toast.LENGTH_SHORT).show();true
        }

    }
}

