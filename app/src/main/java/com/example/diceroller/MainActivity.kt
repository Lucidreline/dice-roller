package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // val toast = Toast.makeText(this, "The dice has been rolled BABY", Toast.LENGTH_SHORT) // message to show user
        // toast.show()

        val myDice = Dice(6) // creates instance of a dice
        val resultTextView: TextView = findViewById(R.id.textView) // finds the counter
        resultTextView.text =
            myDice.roll().toString() // changes the counter text to the random number
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}