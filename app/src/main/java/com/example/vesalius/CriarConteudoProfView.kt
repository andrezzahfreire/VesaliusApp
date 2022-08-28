package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityCodigoSalaViewBinding
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityCriarConteudoProfViewBinding

class CriarConteudoProfView : AppCompatActivity() {
    lateinit var binding: ActivityCriarConteudoProfViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCriarConteudoProfViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}