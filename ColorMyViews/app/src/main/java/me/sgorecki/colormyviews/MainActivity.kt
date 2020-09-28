package me.sgorecki.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val boxes =
            listOf(
                boxOneText,
                boxTwoText,
                boxThreeText,
                boxFourText,
                boxFiveText,
                constraintLayout,
                redButton,
                yellowButton,
                greenButton
            )
        boxes.forEach { it.setOnClickListener { makeColored(it) } }
    }

    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
            R.id.boxTwoText -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.redButton -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellowButton -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.greenButton -> boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}