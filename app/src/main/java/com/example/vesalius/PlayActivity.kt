package com.example.vesalius

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.vesalius.databinding.ActivityPlayBinding
import java.util.*
import java.util.concurrent.TimeUnit

class PlayActivity : AppCompatActivity() {
    private lateinit var activityPlayBinding: ActivityPlayBinding
    //    timer
    private var countDownTimer: CountDownTimer? = null
    private val countDownInMilliSecond: Long = 30000
    private val countDownInterval: Long = 1000
    private var timeLeftMilliSeconds: Long = 0
    private var defaultColor: ColorStateList? = null
    private var score = 0
    private var correct = 0
    private var wrong = 0
    private var skip = 0
    private var qIndex = 0
    private var updateQueNo = 1
    // create string for question, answer and options
    private var questions = arrayOf(
        "Q.1. If a computer has more than one processor then it is known as?",
        "Q.2. Full form of URL is?",
        "Q.3. One kilobyte (KB) is equal to",
        "Q.4. Father of ‘C’ programming language?",
        "Q.5. SMPS stands for",
        "Q.6. What is a floppy disk used for",
        "Q.7. Which operating system is developed and used by Apple Inc?",
        "Q.8. Random Access Memory (RAM) is which storage of device?",
        "Q.9. Who is the founder of the Internet?",
        "Q.10. Which one is the first search engine in internet?")
    private var answer = arrayOf(
        "Multiprocessor",
        "Uniform Resource Locator",
        "1,024 bytes",
        "Dennis Ritchie",
        "Switched mode power supply",
        "To store information",
        "iOS",
        "Primay",
        "Tim Berners-Lee",
        "Archie")
    private var options = arrayOf(
        "Uniprocess",
        "Multiprocessor",
        "Multithreaded",
        "Multiprogramming",
        "Uniform Resource Locator",
        "Uniform Resource Linkwrong",
        "Uniform Registered Link",
        "Unified Resource Link",
        "1,000 bits",
        "1,024 bytes",
        "1,024 megabytes",
        "1,024 gigabytes",
        "Dennis Ritchie",
        "Prof Jhon Kemeny",
        "Thomas Kurtz",
        "Bill Gates",
        "Switched mode power supply",
        "Start mode power supply",
        "Store mode power supply",
        "Single mode power supply",
        "To unlock the computer",
        "To store information",
        "To erase the computer screen",
        "To make the printer work",
        "Windows",
        "Android",
        "iOS",
        "UNIX",
        "Primay",
        "Secondary",
        "Teriary",
        "Off line",
        "Vint Cerf",
        "Charles Babbage",
        "Tim Berners-Lee",
        "None of these",
        "Google",
        "Archie",
        "Altavista",
        "WAIS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlayBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(activityPlayBinding.root)
        initViews()
    }
    @SuppressLint("SetTextI18n")
    private fun showNextQuestion() {
        checkAnswer()
        activityPlayBinding.apply {
            if (updateQueNo < 10) {
                tvNoOfQues.text = "Questão ${updateQueNo + 1}"
                updateQueNo++
            }
            if (qIndex <= questions.size - 1) {
                tvQuestion.text = questions[qIndex]
                radioButton1.text = options[qIndex * 4] // 2*4=8
                radioButton2.text = options[qIndex * 4 + 1] //  2*4+1=9
                radioButton3.text = options[qIndex * 4 + 2] //  2*4+2=10
                radioButton4.text = options[qIndex * 4 + 3] //  2*4+3=11
            } else {
                score = correct
                val intent = Intent(this@PlayActivity, ResultActivity::class.java)
                intent.putExtra("correct", correct)
                intent.putExtra("wrong", wrong)
                intent.putExtra("skip", skip)
                startActivity(intent)
                finish()
            }
            radiogrp.clearCheck()
        }
    }
    @SuppressLint("SetTextI18n")
    private fun checkAnswer() {
        activityPlayBinding.apply {
            if (radiogrp.checkedRadioButtonId == -1) {
                skip++
               // timeOverAlertDialog()
            } else {
                val checkRadioButton =
                    findViewById<RadioButton>(radiogrp.checkedRadioButtonId)
                val checkAnswer = checkRadioButton.text.toString()
                if (checkAnswer == answer[qIndex]) {
                    correct++
                    //txtPlayScore.text = "Score : $correct"
                    correctAlertDialog()
                    countDownTimer?.cancel()
                } else {
                    wrong++
                    wrongAlertDialog()
                    countDownTimer?.cancel()
                }
            }
            qIndex++
        }
    }
    @SuppressLint("SetTextI18n")
    private fun initViews() {
        activityPlayBinding.apply {
            tvQuestion.text = questions[qIndex]
            radioButton1.text = options[0]
            radioButton2.text = options[1]
            radioButton3.text = options[2]
            radioButton4.text = options[3]
            // check options selected or not
            // if selected then selected option correct or wrong
            nextQuestionBtn.setOnClickListener {
                if (radiogrp.checkedRadioButtonId == -1) {
                    Toast.makeText(this@PlayActivity,
                        "Selecione uma alternativa",
                        Toast.LENGTH_SHORT)
                        .show()
                } else {
                    showNextQuestion()
                }
            }
            tvNoOfQues.text = "$updateQueNo/10"
            tvQuestion.text = questions[qIndex]
            //defaultColor = quizTimer.textColors
            timeLeftMilliSeconds = countDownInMilliSecond
            statCountDownTimer()
        }
    }
    private fun statCountDownTimer() {
            showNextQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun correctAlertDialog() {
        val builder = AlertDialog.Builder(this@PlayActivity)
        val view = LayoutInflater.from(this@PlayActivity).inflate(R.layout.correct_answer, null)
        builder.setView(view)
        val tvScore = view.findViewById<TextView>(R.id.tvDialog_score)
        val correctOkBtn = view.findViewById<Button>(R.id.correct_ok)
        tvScore.text = "Resposta correta"
        val alertDialog = builder.create()
        correctOkBtn.setOnClickListener {
            timeLeftMilliSeconds = countDownInMilliSecond
            statCountDownTimer()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
    @SuppressLint("SetTextI18n")
    private fun wrongAlertDialog() {
        val builder = AlertDialog.Builder(this@PlayActivity)
        val view = LayoutInflater.from(this@PlayActivity).inflate(R.layout.wrong_answer, null)
        builder.setView(view)
        val tvWrongDialogCorrectAns = view.findViewById<TextView>(R.id.tv_wrongDialog_correctAns)
        val wrongOk = view.findViewById<Button>(R.id.wrong_ok)
        tvWrongDialogCorrectAns.text = "Resposta correta : " + answer[qIndex]
        val alertDialog = builder.create()
        wrongOk.setOnClickListener {
            timeLeftMilliSeconds =
                countDownInMilliSecond
            statCountDownTimer()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
    @SuppressLint("SetTextI18n")
    private fun timeOverAlertDialog() {
        val builder = AlertDialog.Builder(this@PlayActivity)
        val view = LayoutInflater.from(this@PlayActivity).inflate(R.layout.time_over, null)
        builder.setView(view)
        val timeOverOk = view.findViewById<Button>(R.id.timeOver_ok)
        val alertDialog = builder.create()
        timeOverOk.setOnClickListener {
            timeLeftMilliSeconds = countDownInMilliSecond
            statCountDownTimer()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }
}