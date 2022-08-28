package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityQuizInicioBinding

class QuizInicio : AppCompatActivity() {
    lateinit var binding : ActivityQuizInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}