package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityQuizSelecionadoViewBinding

class QuizSelecionadoView : AppCompatActivity() {
    lateinit var binding : ActivityQuizSelecionadoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityQuizSelecionadoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }// fim on create


}// fim quiz selecionado