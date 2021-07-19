package es.enekodiaz.randomnumbergenerator

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import es.enekodiaz.randomnumbergenerator.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.content.generateButton.setOnClickListener {
            val random = Math.random() * 100
            val roundedRandom = random.roundToInt()
            val animation = AlphaAnimation(1.0f, 0.0f)
            animation.duration = 120
            animation.repeatCount = 1
            animation.repeatMode = Animation.REVERSE
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationEnd(animation: Animation?) { }
                override fun onAnimationStart(animation: Animation?) { }
                override fun onAnimationRepeat(animation: Animation?) {
                    binding.content.numberTextView.text = String.format("%d", roundedRandom)
                    binding.content.numberTextView.textSize = 70f
                }
            })
            binding.content.numberTextView.startAnimation(animation)
        }
    }
}
