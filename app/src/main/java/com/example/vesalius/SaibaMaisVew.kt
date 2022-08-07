package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityEditarDadosViewBinding
import com.example.vesalius.databinding.ActivitySaibaMaisVewBinding
import kotlinx.android.synthetic.main.appbarprin.*

class SaibaMaisVew : AppCompatActivity() {
    private lateinit var binding: ActivitySaibaMaisVewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding
        binding = ActivitySaibaMaisVewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bt voltar action bar
        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }// fim on create

}// fim saiba mais