package com.example.vesalius

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityQuizSelecionadoViewBinding

class QuizSelecionadoView : AppCompatActivity() {
    lateinit var binding : ActivityQuizSelecionadoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizSelecionadoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

       var  tipo = intent.getStringExtra("tipo")
        when (tipo) {
            "esq" -> {
               binding.sisImg.setImageResource(R.drawable.sisesq)
                intent.putExtra("sis","esq")
            }
            "cardio" -> {
                binding.sisImg.setImageResource(R.drawable.cardio)
                intent.putExtra("sis","cardio")
            }
            "fem" -> {
                binding.sisImg.setImageResource(R.drawable.sis_fem)
                intent.putExtra("sis","fem")
            }
            "ner" -> {
                binding.sisImg.setImageResource(R.drawable.sisnervoso)
                intent.putExtra("sis","ner")
            }
            "mus" -> {
                binding.sisImg.setImageResource(R.drawable.sismus)
                intent.putExtra("sis","musc")
            }
            else -> {
                Log.d("img", "Error")
            }
        }

        binding.btVoltar.setOnClickListener {
            finish()
        }

        binding.btPlay.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            when (tipo) {
                "esq" -> {
                    intent.putExtra("sis","esq")
                }
                "cardio" -> {
                    intent.putExtra("sis","cardio")
                }
                "fem" -> {
                    intent.putExtra("sis","fem")
                }
                "ner" -> {
                    intent.putExtra("sis","ner")
                }
                "mus" -> {
                    intent.putExtra("sis","musc")
                }
                else -> {
                    Log.d("img", "Error")
                }
            }
            startActivity(intent)
           // finish()
        }
    }// fim on create


}// fim quiz selecionado