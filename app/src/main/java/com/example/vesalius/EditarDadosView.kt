package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityEditarDadosViewBinding
import kotlinx.android.synthetic.main.appbarprin.*

class EditarDadosView : AppCompatActivity() {
    private lateinit var binding: ActivityEditarDadosViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set binding
        binding = ActivityEditarDadosViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bt voltar action bar
        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }//fim on create

}// fim editar dados