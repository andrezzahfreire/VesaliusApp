package com.example.vesalius.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vesalius.ConteudoView
import com.example.vesalius.EditarDadosView
import com.example.vesalius.R
import com.example.vesalius.databinding.FragmentHomeAlunoIndBinding
import com.example.vesalius.databinding.FragmentPerfilAluIndBinding
import com.google.firebase.auth.FirebaseAuth


class HomeAlunoInd : Fragment() {

    private lateinit var user : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeAlunoIndBinding.inflate(layoutInflater)

        binding.sisCardio.setOnClickListener {
            val intent = Intent(this@HomeAlunoInd.requireContext(), ConteudoView::class.java)
            startActivity(intent)
        }// fim botao

        binding.sisEsq.setOnClickListener {
            val intent = Intent(this@HomeAlunoInd.requireContext(), ConteudoView::class.java)
            startActivity(intent)
        }// fim botao



        binding.sisMusc.setOnClickListener {
            val intent = Intent(this@HomeAlunoInd.requireContext(), ConteudoView::class.java)
            startActivity(intent)
        }// fim botao

        binding.sisNer.setOnClickListener {
            val intent = Intent(this@HomeAlunoInd.requireContext(), ConteudoView::class.java)
            startActivity(intent)
        }// fim botao


        return binding.root
    }


}