package com.example.feastfinder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextTimeOfDay: EditText
    private lateinit var textViewBestMeal: TextView
    private lateinit var clearBtn : Button
    private lateinit var suggestBtn : Button
    private lateinit var exitBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by ID
        editTextTimeOfDay = findViewById(R.id.TimeOfDay)
        suggestBtn = findViewById(R.id.suggestBtn)
        clearBtn = findViewById(R.id.clearBtn)
        textViewBestMeal = findViewById(R.id.textViewbestMeal)
        exitBtn = findViewById(R.id.exitBtn)

        // Reset button click listener
        clearBtn.setOnClickListener {
            editTextTimeOfDay.text.clear()
            textViewBestMeal.text = ""
        }
        // Exit button click listener
        exitBtn.setOnClickListener {
            finishAffinity()
        }
        // Suggest button click listener
        suggestBtn.setOnClickListener {

            val userInput = editTextTimeOfDay.text.toString().trim().lowercase()

            // Check if input is empty
            if (userInput.isEmpty()){
                textViewBestMeal.text ="enter a time of day!"

            }
            else

            // Determine meal suggestion using when

            {val suggestedMeal = when (userInput) {
                "morning" -> "Breakfast: Pancakes with bacon and eggs"
                "mid-morning" -> "Light snack: Fruit salad"
                "afternoon" -> "Lunch: Chicken mayo wraps"
                "afternoon snack" -> "Afternoon snack: Avocado toast or a blueberry smoothie"
                "evening" -> "Dinner: Lasagna or Beef stew with pap"
                else -> null // Invalid input
            }

            if (suggestedMeal != null) {
                textViewBestMeal.text = suggestedMeal


            } else {
                textViewBestMeal.text =
                    "Invalid time! Try Morning, Mid-Morning, Afternoon, or Dinner."

            }
        }
    }}}
