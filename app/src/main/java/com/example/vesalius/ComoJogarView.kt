package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityComoJogarViewBinding
import com.example.vesalius.databinding.ActivityCriarContaViewBinding

class ComoJogarView : AppCompatActivity() {
    lateinit var binding: ActivityComoJogarViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComoJogarViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}