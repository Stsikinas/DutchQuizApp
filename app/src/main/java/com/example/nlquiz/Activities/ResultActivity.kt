package com.example.nlquiz.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.nlquiz.Helpers.Constants
import com.example.nlquiz.R
import com.example.nlquiz.databinding.ActivityQuestionsBinding
import com.example.nlquiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    private lateinit var tvName: TextView
    private lateinit var tvScore: TextView
    private lateinit var btnFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind view to replace findViewById
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupBinding()

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQs = intent.getIntExtra(Constants.TOTAL_Q, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)

        tvScore.text = String.format(getString(R.string.score, score, totalQs))

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun setupBinding() {
        tvName = binding.tvName
        tvScore = binding.tvScore
        btnFinish = binding.btnFinish
    }
}