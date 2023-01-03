package com.example.bmicalculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightText = findViewById<EditText>(R.id.mEdtHeight)
        val weightText = findViewById<EditText>(R.id.mEdtWeight)
        val buttonCalc= findViewById<Button>(R.id.mBtnCalculate)

        buttonCalc.setOnClickListener(){
            val height = heightText.text.toString()
            val weight = weightText.text.toString()


            if (height == "" || weight == ""){
                Toast.makeText(this, "Please fill all the inputs!!!", Toast.LENGTH_LONG).show()
            } else{
                val bmi = weight.toFloat() / (height.toFloat()/100 * height.toFloat()/100)
                val bmi2Digits = String.format("%.2f", bmi).toFloat()
                displayResults(bmi2Digits)
            }
        }

    }

    private fun displayResults (bmi:Float){
        val resultText = findViewById<TextView>(R.id.mTvResult)
        val resultDescription = findViewById<TextView>(R.id.mTvResultDescription)
        val infoText = findViewById<TextView>(R.id.mTvInfo)

        infoText.text = "Normal BMI is 18.5 - 24.9"
        resultText.text = bmi.toString()

        var result = ""

        when{
            bmi < 18.50 -> {
               result = "You're underweight"
            }
            bmi in 18.50 .. 24.99 -> {
                result = "You're healthy"
            }
            bmi in 25.00 .. 29.99 -> {
                result = "You're overweight"
            }
            bmi > 30 ->{
                result =  "You're obese"
            }

        }

        resultDescription.text = result
    }
}

