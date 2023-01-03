package com.example.nlquiz.Helpers

import com.example.nlquiz.Models.Question
import com.example.nlquiz.R

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "Which is the closest capital from Amsterdam?",
            R.drawable.ic_map,
            listOf("London", "Paris", "Brussels", "Copenhagen" ),
            3
        )
        questionsList.add(q1)

        val q2 = Question(
            2,
            "Who is this famous painter?",
            R.drawable.ic_vvg,
            listOf("Vincent Van Gogh", "Govert Flinck", "Paulus Potter", "Rembrandt" ),
            1
        )
        questionsList.add(q2)

        val q3 = Question(
            3,
            "Which footbal team has Galgenwaard as home stadium?",
            R.drawable.ic_galgenwaard,
            listOf("Ajax", "Feyenoord", "Almere", "FC Utrecht" ),
            4
        )
        questionsList.add(q3)

        val q4 = Question(
            4,
            "When was King Willem-Alexander crowned?",
            R.drawable.ic_king,
            listOf("25/3/2013", "1/1/2013", "30/4/2013", "30/1/2013" ),
            3
        )
        questionsList.add(q4)

        val q5 = Question(
            5,
            "What does \"Handschoenen\" mean?",
            R.drawable.ic_alphabet,
            listOf("Hands", "Gloves", "Eyes", "Bicycles" ),
            2
        )
        questionsList.add(q5)

        val q6 = Question(
            6,
            "Which countries liberated NL in WW2?",
            R.drawable.ic_liberation,
            listOf("Canada/Britain/Poland", "Canada/Spain/France", "Spain/France", "Canada/USA" ),
            1
        )
        questionsList.add(q6)

        val q7 = Question(
            7,
            "Which Dutch TV program had the most accolades nation-wide in 2020?",
            R.drawable.ic_tv_program,
            listOf("Journaal extra", "Het Journaal", "NOS Sports", "Voice van Holland" ),
            1
        )
        questionsList.add(q7)

        val q8 = Question(
            8,
            "Which traditional snack is considered the most popular by locals?",
            R.drawable.ic_hollandse_nieuwe,
            listOf("Oliebollen", "Pannekoeken", "Kroket", "Hollandse Nieuwe" ),
            4
        )
        questionsList.add(q8)

        val q9 = Question(
            9,
            "Which Dutch song had the most streams in Spotify in 2021?",
            R.drawable.ic_music,
            listOf("Goud", "Blijven slapen", "Picollo", "Bon Gepakt" ),
            2
        )
        questionsList.add(q9)

        val q10 = Question(
            10,
            "Which Dutch region's flag is this?",
            R.drawable.ic_friesland_flag,
            listOf("Zuid-Holland", "Flevoland", "Zeeland", "Friesland" ),
            4
        )
        questionsList.add(q10)

        return questionsList
    }

}