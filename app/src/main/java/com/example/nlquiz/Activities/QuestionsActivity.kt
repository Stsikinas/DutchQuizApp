package com.example.nlquiz.Activities

import android.content.Intent
import android.content.res.Resources
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.nlquiz.Helpers.Constants
import com.example.nlquiz.Models.Question
import com.example.nlquiz.R
import com.example.nlquiz.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedPosition: Int = 0
    private var mScore: Int = 0
    private var mUsername: String? = null

    private lateinit var binding: ActivityQuestionsBinding

    private lateinit var tvQuestion: TextView
    private lateinit var ivImage: ImageView

    private lateinit var pbProgress: ProgressBar
    private lateinit var tvProgress: TextView

    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView

    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        // Bind view to replace findViewById
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupBindings()

        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }

    private fun setupBindings() {

        tvQuestion = binding.tvQuestion
        ivImage = binding.ivImage

        pbProgress = binding.pbProgress
        tvProgress = binding.tvProgress

        tvOptionOne = binding.tvOptionOne
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo = binding.tvOptionTwo
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree = binding.tvOptionThree
        tvOptionThree.setOnClickListener(this)
        tvOptionFour = binding.tvOptionFour
        tvOptionFour.setOnClickListener(this)

        btnSubmit = binding.btnSubmit
        btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion() {
        defaultOptionsView()
        // We know that list can't be empty
        val question = mQuestionsList!![mCurrentPosition - 1]

        pbProgress.progress = mCurrentPosition
        tvProgress.text = String.format(getString(R.string.progress_text), mCurrentPosition, pbProgress.max)

        tvQuestion.text = question.question
        ivImage.setImageResource(question.image)

        tvOptionOne.text = question.options[0]
        tvOptionTwo.text = question.options[1]
        tvOptionThree.text = question.options[2]
        tvOptionFour.text = question.options[3]

    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options) {
            option.setTypeface(Typeface.DEFAULT)
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
        if (mCurrentPosition != mQuestionsList?.size) {
            btnSubmit.text = getString(R.string.submit)
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionPos: Int) {
        defaultOptionsView()

        mSelectedPosition = selectedOptionPos

        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tvOptionOne -> tvOptionOne.let {
                selectedOptionView(it, 1)
            }
            R.id.tvOptionTwo -> tvOptionTwo.let {
                selectedOptionView(it, 2)
            }
            R.id.tvOptionThree -> tvOptionThree.let {
                selectedOptionView(it, 3)
            }
            R.id.tvOptionFour -> tvOptionFour.let {
                selectedOptionView(it, 4)
            }
            R.id.btnSubmit -> {
                if (mSelectedPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= (mQuestionsList?.size ?: 0) -> {
                            setQuestion()
                        }
                        else -> showResultsScreen()
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    showResult(question!!)
                }
            }
        }
    }

    private fun showResult(question: Question) {
        if (question.correctIndex != mSelectedPosition) {
            selectAnswerView(mSelectedPosition, R.drawable.incorrect_option_border)
        } else {
            mScore++
        }
        selectAnswerView(question.correctIndex, R.drawable.correct_option_border)

        if (mCurrentPosition == mQuestionsList!!.size)
            btnSubmit.text = getString(R.string.finish)
        else
            btnSubmit.text = getString(R.string.move_to_next)

        mSelectedPosition = 0
    }

    private fun showResultsScreen() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, mUsername)
        intent.putExtra(Constants.TOTAL_Q, mQuestionsList?.size)
        intent.putExtra(Constants.SCORE, mScore)
        startActivity(intent)
        finish()
    }

    private fun selectAnswerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}