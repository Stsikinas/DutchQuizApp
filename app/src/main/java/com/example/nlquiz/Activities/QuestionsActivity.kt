package com.example.nlquiz.Activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.nlquiz.Helpers.Constants
import com.example.nlquiz.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind view to replace findViewById
        val binding = ActivityQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val questions = Constants.getQuestions()
        Log.i("Questions List size", "${questions.size}")
    }
}