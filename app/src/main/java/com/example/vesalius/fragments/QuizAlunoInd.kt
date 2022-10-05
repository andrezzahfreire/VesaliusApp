package com.example.vesalius.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vesalius.ConteudoView
import com.example.vesalius.QuizInicio
import com.example.vesalius.R
import com.example.vesalius.databinding.FragmentHomeAlunoIndBinding
import com.example.vesalius.databinding.FragmentPerfilAluIndBinding
import com.example.vesalius.databinding.FragmentQuizAlunoIndBinding
import com.google.firebase.auth.FirebaseAuth


class QuizAlunoInd : Fragment() {

    private lateinit var user : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentQuizAlunoIndBinding.inflate(layoutInflater)

        binding.sisCardio.setOnClickListener {
            val intent = Intent(this@QuizAlunoInd.requireContext(), QuizInicio::class.java)
            startActivity(intent)
        }// fim botao

        return binding.root
    }


}