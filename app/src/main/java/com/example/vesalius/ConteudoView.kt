package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityConteudoViewBinding
import com.example.vesalius.databinding.ActivityCriarContaViewBinding

class ConteudoView : AppCompatActivity() {
    lateinit var binding: ActivityConteudoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConteudoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}