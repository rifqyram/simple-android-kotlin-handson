package com.enigma.myandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class BoardActivity : AppCompatActivity() {

    private var activePlayer = 1
    private lateinit var textView: TextView
    private lateinit var quitBtn: MaterialButton
    private lateinit var rematchBtn: MaterialButton

    private val player1 = mutableListOf<Int>()
    private val player2 = mutableListOf<Int>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        textView = findViewById(R.id.playerTv)
        val player1 = intent.getStringExtra("PLAYER_1")
        textView.text = "${player1}'s Turn"

        quitBtn = findViewById(R.id.quit_btn)
        quitBtn.setOnClickListener { quitGame() }

        rematchBtn = findViewById(R.id.rematch_btn)
        rematchBtn.setOnClickListener { rematchGame() }
    }

    private fun rematchGame() {
        val intent = Intent(this, BoardActivity::class.java)
        finish()
        startActivity(intent)
    }

    private fun quitGame() {
        finish()
    }

    @SuppressLint("SetTextI18n")
    private fun playGame(buttonSelected: MaterialButton, value: Int) {
        val player1 = intent.getStringExtra("PLAYER_1")
        val player2 = intent.getStringExtra("PLAYER_2")

        if (activePlayer == 1) {
            textView.text = "${player1}'s Turn"
            buttonSelected.text = "X"
            this.player1.add(value)
            activePlayer = 2
        } else {
            textView.text = "${player2}'s Turn"
            buttonSelected.text = "O"
            this.player2.add(value)
            activePlayer = 1
        }

        buttonSelected.isEnabled = false

        getWinner()
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as MaterialButton
        var value = 0

        when (buttonSelected.id) {
            R.id.button1 -> value = 1
            R.id.button2 -> value = 2
            R.id.button3 -> value = 3
            R.id.button4 -> value = 4
            R.id.button5 -> value = 5
            R.id.button6 -> value = 6
            R.id.button7 -> value = 7
            R.id.button8 -> value = 8
            R.id.button9 -> value = 9
        }

        playGame(buttonSelected, value)
    }

    private fun getWinner() {
        val playerOne = intent.getStringExtra("PLAYER_1")
        val playerTwo = intent.getStringExtra("PLAYER_2")

        var winner = -1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }


        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, " $playerOne  win the game", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, " $playerTwo win the game", Toast.LENGTH_LONG).show()
                finish()

            }
        }
    }
}
