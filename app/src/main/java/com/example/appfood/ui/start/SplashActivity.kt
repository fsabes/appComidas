package com.example.appfood.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.appfood.R
import com.example.appfood.ui.main.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.navigationBarColor = resources.getColor(R.color.red);

        Handler(Looper.getMainLooper()).postDelayed(
            {
                finish()
                startActivity(Intent(this,HomeActivity::class.java))
            }, 3000)
    }
}