package com.example.lyfecycleindexmassytela

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var heightET: EditText
    private lateinit var weightET: EditText
    private lateinit var buttonCalculateBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        heightET = findViewById(R.id.heightET)
        weightET = findViewById(R.id.weightET)
        buttonCalculateBTN = findViewById(R.id.buttonCalculateBTN)

        buttonCalculateBTN.setOnClickListener{view ->
            if (heightET.text.isEmpty() ||
                weightET.text.isEmpty() ||
                heightET.text.toString().toInt() < 20 ||
                heightET.text.toString().toInt() > 350 ||
                weightET.text.toString().toInt() < 1 ||
                weightET.text.toString().toInt() > 500) {
                Snackbar.make(view, "Данные введены неверно!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("height", heightET.text.toString())
            intent.putExtra("weight", weightET.text.toString())
            startActivity(intent)
        }

    }
}