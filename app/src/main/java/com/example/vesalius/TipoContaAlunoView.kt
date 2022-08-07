package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityTipoContaAlunoViewBinding
import kotlinx.android.synthetic.main.appbarprin.*

class TipoContaAlunoView : AppCompatActivity() {
    private lateinit var binding: ActivityTipoContaAlunoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTipoContaAlunoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bt voltar action bar
        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //passa o tipo de aluno

        binding.btIndividual.setOnClickListener {
            val intent = Intent(this, CriarContaView::class.java)
            intent.putExtra("tipo","Aluno Individual")
            startActivity(intent)
           finish()

        }//fim onclick

        binding.btInst.setOnClickListener {
            val intent = Intent(this, CriarContaView::class.java)
            intent.putExtra("tipo","Aluno Acompanhado")
            startActivity(intent)

            finish()
        }
    }//fim on create
}// fim classe tipo