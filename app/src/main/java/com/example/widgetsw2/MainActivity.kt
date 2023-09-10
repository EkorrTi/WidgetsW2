package com.example.widgetsw2

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondHand = findViewById<View>(R.id.sec_arrow)



        val secondAnim = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.8f
        )

        secondAnim.duration = 60000
        secondAnim.repeatCount = Animation.INFINITE
        secondAnim.interpolator = LinearInterpolator()

        secondHand.startAnimation(secondAnim)
    }
}