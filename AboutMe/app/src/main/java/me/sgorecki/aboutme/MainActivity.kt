package me.sgorecki.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import me.sgorecki.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.doneButton.setOnClickListener { addNickname(it) }

        setContentView(view)
    }

    private fun addNickname(view: View) {
        val nickNameEdit = binding.nickname
        val nickNameText = binding.nicknameText
        nickNameText.text = nickNameEdit.text

        nickNameEdit.visibility = View.GONE
        view.visibility = View.GONE
        nickNameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}