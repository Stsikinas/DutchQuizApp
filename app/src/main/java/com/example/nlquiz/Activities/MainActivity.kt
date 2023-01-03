package com.example.nlquiz.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nlquiz.Helpers.Constants
import com.example.nlquiz.R
import com.example.nlquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind view to replace findViewById
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnLogin = binding.btnLogin
        etName = binding.etName

        btnLogin.setOnClickListener {
            if (etName.text.isNullOrEmpty())
                Toast.makeText(this, getString(R.string.empty_name_warning), Toast.LENGTH_LONG).show()
            else
                moveToQuestions()
        }
    }

    private fun moveToQuestions() {
        val intent = Intent(this, QuestionsActivity::class.java)
        intent.putExtra(Constants.USER_NAME, etName.text.toString())
        startActivity(intent)
        finish()
    }

}