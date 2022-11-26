package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vesalius.databinding.ActivityEscolherAssuntoQuizBinding
import com.example.vesalius.databinding.ActivityQuizInicioBinding
import com.example.vesalius.databinding.ActivityQuizSelecionadoViewBinding

class EscolherAssuntoQuiz : AppCompatActivity() {
    lateinit var binding : ActivityEscolherAssuntoQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEscolherAssuntoQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEsq.setOnClickListener {
            val intent = Intent(this, QuizSelecionadoView::class.java)
            intent.putExtra("tipo","esq")
            startActivity(intent)

            finish()
        }

        binding.btCardio.setOnClickListener {
            val intent = Intent(this, QuizSelecionadoView::class.java)
            intent.putExtra("tipo","cardio")
            startActivity(intent)

            finish()
        }

        binding.btFem.setOnClickListener {
            val intent = Intent(this, QuizSelecionadoView::class.java)
            intent.putExtra("tipo","fem")
            startActivity(intent)

            finish()
        }
        binding.btNer.setOnClickListener {
            val intent = Intent(this, QuizSelecionadoView::class.java)
            intent.putExtra("tipo","ner")
            startActivity(intent)

            finish()
        }
        binding.btMusc.setOnClickListener {
            val intent = Intent(this, QuizSelecionadoView::class.java)
            intent.putExtra("tipo","mus")
            startActivity(intent)

            finish()
        }
    }
}