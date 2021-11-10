package com.enigma.pascalandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var calcTv: TextView
    lateinit var lengthInput: TextInputEditText
    lateinit var widthInput: TextInputEditText
    lateinit var heightInput: TextInputEditText
    lateinit var button: MaterialButton

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.calc_btn)
        calcTv = findViewById(R.id.calc_tv)
        lengthInput = findViewById(R.id.input_length)
        widthInput = findViewById(R.id.input_width)
        heightInput = findViewById(R.id.input_height)

        button.setOnClickListener {
            if (lengthInput.text.isNullOrBlank() || heightInput.text.isNullOrBlank() || widthInput.text.isNullOrBlank()) {
                calcTv.text = "Invalid input!"
            } else {
                calcOnPress()
            }
        }
    }

    private fun calculate(length: Int, width: Int, height: Int) = length * width * height

    private fun calcOnPress() {
        val length = lengthInput.text.toString().toInt()
        val width = widthInput.text.toString().toInt()
        val height = heightInput.text.toString().toInt()
        val calculate = calculate(length, width, height)
        calcTv.text = "$calculate"
    }

}