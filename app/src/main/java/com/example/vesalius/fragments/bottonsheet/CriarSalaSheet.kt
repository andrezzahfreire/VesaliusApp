package com.example.vesalius.fragments.bottonsheet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.vesalius.*
import com.example.vesalius.databinding.FragmentCriarSalaSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap
import kotlin.random.Random.Default.nextInt
import java.util.Random


class CriarSalaSheet : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentCriarSalaSheetBinding
    private lateinit var salaViewModel: SalaViewModel
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        firebaseAuth = FirebaseAuth.getInstance()

       // salaViewModel = ViewModelProvider(activity).get(S)
        binding.btCriarsalashet.setOnClickListener {
            saveAction()
            dismiss()
        }

        binding.btClose.setOnClickListener {
            dismiss()
        }


    }

    private fun saveAction() {

        val codigo = (10000..100000).random().toString()
        val nome = binding.nomesalaEdt.text.toString()
        val turma = binding.nometurmaEdt.text.toString()
        val professor= binding.nomeprofessorEdt.text.toString()
        criarSala(nome, codigo, turma, professor)
        dismiss()

        val intent = Intent(this@CriarSalaSheet.requireContext(), HomeProfessorView::class.java)
        startActivity(intent)

    }

    fun criarSala (nome:String,codigo:String,turma:String,professor :String){
        val db = FirebaseFirestore.getInstance()
        val uid =  firebaseAuth.currentUser?.uid.toString()
        val sala: MutableMap<String,Any> = HashMap()
        sala ["nome"] = nome
        sala ["codigo"] = codigo
        sala ["turma"] = turma
        sala ["professor"] = professor

        db.collection("salas").document(codigo).set(sala)
            .addOnCompleteListener { task->
                if(task.isSuccessful){

                }else{
                 //   Toast.makeText(this@CriarSalaSheet.requireContext(), task.exception.toString(),Toast.LENGTH_SHORT).show()
                }

            }
    }






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCriarSalaSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


}