package com.example.nlquiz.Models

import android.media.Image

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val options: List<String>,
    val correctIndex: Int
)
