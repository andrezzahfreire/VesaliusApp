package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityRankingQuizViewBinding

class RankingQuizView : AppCompatActivity() {
    lateinit var binding : ActivityRankingQuizViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRankingQuizViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }     //fim on create
}     //fim ranking