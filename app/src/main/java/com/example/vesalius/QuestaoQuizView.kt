package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityQuestaoQuizViewBinding

class QuestaoQuizView : AppCompatActivity() {
    lateinit var binding :ActivityQuestaoQuizViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestaoQuizViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    } // fim on create
} // fim questao