package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityFinalQuizViewBinding

class FinalQuizView : AppCompatActivity() {
    lateinit var binding : ActivityFinalQuizViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinalQuizViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }  // fim on create

}  // fim final quiz
