package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    lateinit var cakeImageView: ImageView

    fun setOpacity(percent:Int)
    {
        cakeImageView.alpha = percent / 100f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)
        val revealScope = CoroutineScope(Job() + Dispatchers.Default)
        findViewById<Button>(R.id.revealButton).setOnClickListener{
            revealScope.launch {
                repeat(100) {
                    setOpacity(it)
                    delay(40)
                }
            }
        }
    }
}