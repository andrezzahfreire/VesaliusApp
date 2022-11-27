package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vesalius.databinding.ActivityHomeAlunoAcomViewBinding
import com.example.vesalius.util.CustomAdapter
import kotlinx.android.synthetic.main.appbarprin.*

class HomeAlunoAcomView : AppCompatActivity() {
    private lateinit var binding: ActivityHomeAlunoAcomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeAlunoAcomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.btPerfil.setOnClickListener {
            val intent = Intent (this, PerfilProfView::class.java)
            intent.putExtra("tipo","Aluno Acompanhado")
            startActivity(intent)

            finish()
        }

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()



     binding.btEntrarSala.setOnClickListener {
             val intent = Intent(this,CodigoSalaView::class.java)
            startActivity(intent)
        }

    }// fim on create



}// fim home aluno