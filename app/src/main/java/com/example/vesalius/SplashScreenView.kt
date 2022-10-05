package com.example.vesalius

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashScreenView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_view)

        //troca cor statud bar
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.rosa)
        } //fim if


        //espera 3 segundos para iniciar a proxima activity
        Handler().postDelayed({
         val intent = Intent(this, OnBoardView ::class.java)
            startActivity(intent)
            finish()
        },3000) // fim post delayed
    } // fim on create

} // fim splash