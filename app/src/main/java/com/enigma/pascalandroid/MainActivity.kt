package com.enigma.pascalandroid

import android.annotation.SuppressLint
import android.app.Activity
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.view.WindowCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var count: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count = findViewById(R.id.textView)
        val btnIncrement: MaterialButton = findViewById(R.id.btn_increment)
        val btnDecrement: MaterialButton = findViewById(R.id.btn_decrement)
        btnIncrement.setOnClickListener { increment() }
        btnDecrement.setOnClickListener { decrement() }

    }

    private fun increment() {
        val currentNumber = count.text.toString().toInt()
        count.text = (currentNumber + 1).toString()
    }

    private fun decrement() {
        val currentNumber = count.text.toString().toInt()

        if (currentNumber <= 0) {
            count.text = "0"
        } else {
            count.text = (currentNumber - 1).toString()
        }
    }
}