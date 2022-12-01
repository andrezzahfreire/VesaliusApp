package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityAnotacoesBinding
import com.example.vesalius.databinding.ActivityNovaNotaBinding

class NovaNota : AppCompatActivity() {
    private lateinit var binding: ActivityNovaNotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovaNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}