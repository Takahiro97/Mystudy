package com.example.mydata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val message=intent.getStringExtra(EXTRA_MESSAGE)
        val dataText=findViewById<TextView>(R.id.subText).apply{
            text=message
        }
    }
}