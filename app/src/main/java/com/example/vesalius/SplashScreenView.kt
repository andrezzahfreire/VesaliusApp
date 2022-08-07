package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_view)

        //espera 3 segundos para iniciar a proxima activity
        Handler().postDelayed({
         val intent = Intent(this, OnBoardView ::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}