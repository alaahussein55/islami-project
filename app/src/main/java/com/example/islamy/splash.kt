package com.example.islamy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this,homeScreen::class.java)
             startActivity(intent)},2000)

    }
}