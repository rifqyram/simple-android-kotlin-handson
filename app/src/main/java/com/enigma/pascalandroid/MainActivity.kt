package com.enigma.pascalandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun sendData() {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra(SecondActivity.GET_NAME, input_greeting.text.toString())
        input_greeting.setText("")
        startActivity(intent)
    }
}