package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val EXTRA_POSITION_X: String = "com.example.mysampleapp.X"

    val EXTRA_POSITION_Y: String = "com.example.mysampleapp.Y"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun IncreaseCount(view: View) {
        var mainTextView : TextView = findViewById(R.id.countTxt)
        var value = Integer.parseInt(mainTextView.text.toString())
        value += 1
        mainTextView.text = value.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", "Hallo")
        intent.putExtra("name1", "Tschuss")
        intent.putExtra(EXTRA_POSITION_X, 100 )
        intent.putExtra(EXTRA_POSITION_Y, 500)
        this.startActivity(intent)
    }


}