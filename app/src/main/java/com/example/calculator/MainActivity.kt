package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var prevValue: Double = 0.00
    private var onGoingOperation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun onNumberClick(view: View){
        val resultView: TextView = findViewById(R.id.calcResult)
        if (resultView.text == "0"){
            resultView.text = ""
        }
        val button: Button = view as Button
        val buttonText: String = button.text.toString()
        resultView.text = resultView.text.toString() + buttonText
    }

    fun onOperatorClick(view: View){
        val resultView: TextView = findViewById(R.id.calcResult)
        val prevView: TextView= findViewById(R.id.previousNum)
        val opButton:Button = view as Button

        prevValue = resultView.text.toString().toDouble()

        prevView.text = prevValue.toString()
        resultView.text = ""

        onGoingOperation = opButton.text.toString()
    }

    @SuppressLint("SetTextI18n")
    fun computeExpression(view: View){
        val resultView: TextView = findViewById(R.id.calcResult)
        val prevView: TextView= findViewById(R.id.previousNum)
        if (onGoingOperation.isNotBlank()){
            prevView.text = ""
            val presentValue: Double = resultView.text.toString().toDouble()
            when(onGoingOperation){
                "+" -> resultView.text = "${prevValue+presentValue}"
                "-" -> resultView.text = "${prevValue-presentValue}"
                "*" -> resultView.text = "${prevValue*presentValue}"
                "/" -> resultView.text = "${prevValue/presentValue}"
            }
            onGoingOperation = ""
            prevValue = 0.00
        }
    }

    fun clearMemory(view: View){
        val resultView: TextView = findViewById(R.id.calcResult)
        val prevView: TextView= findViewById(R.id.previousNum)
        onGoingOperation = ""
        prevValue = 0.00
        prevView.text = ""
        resultView.text = "0"

    }
}