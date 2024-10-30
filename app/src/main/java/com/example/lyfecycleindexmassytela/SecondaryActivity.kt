package com.example.lyfecycleindexmassytela

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class SecondaryActivity : AppCompatActivity() {

    private lateinit var indexMassBodyTV: TextView
    private lateinit var imageBodyTypeIV: ImageView
    private lateinit var infoForWeightLossTV: TextView
    private lateinit var buttonBackBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        indexMassBodyTV = findViewById(R.id.indexMassBodyTV)
        imageBodyTypeIV = findViewById(R.id.imageBodyTypeIV)
        infoForWeightLossTV = findViewById(R.id.infoForWeightLossTV)
        buttonBackBTN = findViewById(R.id.buttonBackBTN)

        buttonBackBTN.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }

        val height = intent.getStringExtra("height")!!.toDouble()
        val weight = intent.getStringExtra("weight")!!.toDouble()
        val indexMassBody = (weight / ((height / 100) * (height / 100))).toInt()
        indexMassBodyTV.text = indexMassBody.toString()
        when(indexMassBody) {
            in 1..17 -> {
                imageBodyTypeIV.setImageResource(R.drawable.index_mass_body_green)
                infoForWeightLossTV.setText(R.string.easy_mass_body)
            }
            in 18..25 -> {
                imageBodyTypeIV.setImageResource(R.drawable.index_mass_body_green)
                infoForWeightLossTV.setText(R.string.normal_mass_body)
            }
            in 25..30 -> {
                imageBodyTypeIV.setImageResource(R.drawable.index_mass_body_orange)
                infoForWeightLossTV.setText(R.string.medium_mass_body)
            }
            in 30..1000 -> {
                imageBodyTypeIV.setImageResource(R.drawable.index_mass_body_red)
                infoForWeightLossTV.setText(R.string.hard_mass_body)
            }
            else -> {
                Snackbar.make(infoForWeightLossTV, "Данные введены неверно", Snackbar.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                finish()
            }
        }
    }
}