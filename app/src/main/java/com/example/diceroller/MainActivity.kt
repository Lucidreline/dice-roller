package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice() // displays a random dice when the app first opens up
    }

    private fun rollDice() {
        // val toast = Toast.makeText(this, "The dice has been rolled BABY", Toast.LENGTH_SHORT) // message to show user
        // toast.show()

        val myDice = Dice(6) // creates instance of a dice

        val diceImage: ImageView = findViewById(R.id.imageView) // grabs the image view

        val imageToUse = when(myDice.roll()){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(imageToUse) // sets the image to be the correct dice roll
        diceImage.contentDescription = myDice.roll().toString() // lets people who use screenreaders to know the number
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}