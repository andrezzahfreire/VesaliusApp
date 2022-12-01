package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vesalius.databinding.ActivityCodigoSalaViewBinding

class CodigoSalaView : AppCompatActivity() {
    private lateinit var binding: ActivityCodigoSalaViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCodigoSalaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrarsalsacod.setOnClickListener {
            val intent = Intent(this,HomeAlunoAcomView::class.java)
            startActivity(intent)
        }
    }
}