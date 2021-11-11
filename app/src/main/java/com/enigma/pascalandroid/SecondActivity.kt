package com.enigma.pascalandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val GET_NAME = "get_name"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val getName = intent.getStringExtra(GET_NAME)
        if (!getName.isNullOrBlank()) {
            greeting_tv.text = "Halo $getName"
        }

        back_btn.setOnClickListener {
            back()
        }
    }

    private fun back() {
        finish()
    }
}