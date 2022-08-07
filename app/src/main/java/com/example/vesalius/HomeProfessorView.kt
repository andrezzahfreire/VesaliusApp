package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vesalius.databinding.ActivityHomeProfessorViewBinding
import kotlinx.android.synthetic.main.appbarprin.*

class HomeProfessorView : AppCompatActivity() {

    private lateinit var binding: ActivityHomeProfessorViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeProfessorViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btCriarassunto.setOnClickListener {
            Toast.makeText(this,"Funcionando",Toast.LENGTH_SHORT)
        }

    }
}