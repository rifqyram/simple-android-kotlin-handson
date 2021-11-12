package com.enigma.myandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var startBtn: Button
    lateinit var inputPlayer1: TextInputEditText
    lateinit var inputPlayer2: TextInputEditText

    companion object {
        const val PLAYER_1 = "PLAYER_1"
        const val PLAYER_2 = "PLAYER_2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn = findViewById(R.id.start_btn)
        inputPlayer1 = findViewById(R.id.player1_input)
        inputPlayer2 = findViewById(R.id.player2_input)

        startBtn.setOnClickListener { toBoardActivity() }
    }

    private fun toBoardActivity() {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra(PLAYER_1, inputPlayer1.text.toString())
        intent.putExtra(PLAYER_2, inputPlayer2.text.toString())
        startActivity(intent)
    }

}