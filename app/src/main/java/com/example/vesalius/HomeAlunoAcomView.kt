package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityHomeAlunoAcomViewBinding
import kotlinx.android.synthetic.main.appbarprin.*

class HomeAlunoAcomView : AppCompatActivity() {
    private lateinit var binding: ActivityHomeAlunoAcomViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeAlunoAcomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btEntrarsala.setOnClickListener {
             val intent = Intent(this,CodigoSalaView::class.java)
            startActivity(intent)
        }

        binding.btDados.setOnClickListener {
            val intent = Intent(this,CodigoSalaView::class.java)
            startActivity(intent)
        }
    }// fim on create

}// fim home aluno