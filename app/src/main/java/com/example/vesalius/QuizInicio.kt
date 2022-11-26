package com.example.vesalius

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.example.vesalius.databinding.ActivityQuizInicioBinding

class QuizInicio : AppCompatActivity() {
    lateinit var binding : ActivityQuizInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btJogar.setOnClickListener {
            val intent = Intent(this, EscolherAssuntoQuiz::class.java)
            startActivity(intent)
            finish()
        }
        binding.btComojogar.setOnClickListener {
            val intent = Intent(this, ComoJogarView::class.java)
            startActivity(intent)
            finish()
        }

        binding.btSair.setOnClickListener {
            finish()
        }
        binding.btNivel.setOnClickListener {
            val listItems = arrayOf("Fácil", "Médio", "Difícil")
            val mBuilder = AlertDialog.Builder(this@QuizInicio)
            mBuilder.setTitle("Selecione o nível do jogo")
            mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
               /// txtView.text = listItems[i]
                dialogInterface.dismiss()
            }
            // Set the neutral/cancel button click listener
            mBuilder.setNeutralButton("cancelar") { dialog, which ->
                // Do something when click the neutral button
                dialog.cancel()
            }
            val mDialog = mBuilder.create()
            mDialog.show()

        }



    }

    }





