package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityAssuntoQuizBinding
import com.example.vesalius.databinding.ActivityCriarContaViewBinding

class AssuntoQuiz : AppCompatActivity() {
    lateinit var binding : ActivityAssuntoQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAssuntoQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}