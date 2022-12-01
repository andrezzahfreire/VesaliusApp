package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityAnotacoesBinding
import com.example.vesalius.databinding.ActivityPerfilProfViewBinding

class Anotacoes : AppCompatActivity() {
    private lateinit var binding: ActivityAnotacoesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnotacoesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btMais.setOnClickListener {
            val intent = Intent(this,NovaNota::class.java)
            startActivity(intent)
        }
    }
}