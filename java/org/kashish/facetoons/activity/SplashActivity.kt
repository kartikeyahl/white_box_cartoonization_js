package org.kashish.facetoons.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_splash.*
import org.kashish.facetoons.R

class SplashActivity : AppCompatActivity() {

    lateinit var anim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Set video path
        val videoPath = "android.resource://$packageName/raw/splash"
        splash.setVideoPath(videoPath)
        splash.setOnCompletionListener {
            val r = object:Runnable{
                override fun run() {
                    startActivity(Intent(this@SplashActivity,BoardingActivity::class.java))
                    finish()
                }
            }
            Handler().postDelayed(r,50) //waiting time for new activity
        }
        splash.start() //play

    }
}