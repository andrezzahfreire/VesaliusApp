package com.example.vesalius.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.vesalius.*
import com.example.vesalius.databinding.FragmentPerfilAluIndBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilAluInd : Fragment() {

    private lateinit var user : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPerfilAluIndBinding.inflate(layoutInflater)

        val db = FirebaseFirestore.getInstance()
        val uid = FirebaseAuth.getInstance().currentUser!!.email
         db.collection("users").whereEqualTo("email",uid)
             .get()
             .addOnCompleteListener {

                 val result : StringBuffer = StringBuffer ()

                 if (it.isSuccessful){
                    for(document in it.result !!) {
                      binding.txtNomecomp.text = document.getString("nome").plus(" ").plus(document.getString("sobrenome"))
                        var txt : String = "Estudante de "
                        binding.txtArea.text = txt.plus(document.getString("area"))
                        binding.txtEmailperfil.text = document.getString("email")
                    }

                 }

             }


        //vai editar dados
        binding.btIreditarperfil.setOnClickListener {
            val intent = Intent(this@PerfilAluInd.requireContext(), EditarDadosView::class.java)
            startActivity(intent)
        }// fim botao

        // vai redefinir senha
        binding.btRedefinirsenha.setOnClickListener {
            val intent = Intent (this@PerfilAluInd.requireContext(), RecuperarSenhaView :: class.java)
            startActivity(intent)
        }

        // vai pra saiba mais
        binding.btIrsaibamais.setOnClickListener {
            val intent = Intent (this@PerfilAluInd.requireContext(), SaibaMaisVew ::class.java)
            startActivity(intent)
        }

        user = FirebaseAuth.getInstance()

        // logout da conta
        binding.btSairconta.setOnClickListener {
            user.signOut()
            val intent = Intent(this@PerfilAluInd.requireContext(), LoginView::class.java)
            startActivity(intent)
            Toast.makeText(this@PerfilAluInd.requireContext(),"Deslogado com sucesso",Toast.LENGTH_SHORT).show()
        }

        // deleta conta
        binding.btExcluirconta.setOnClickListener {
            val credential = EmailAuthProvider
                .getCredential("user@example.com", "password1234")

            user.currentUser!!.reauthenticate(credential).addOnCompleteListener {
                    task ->
                if(task.isSuccessful){
                    Toast.makeText(this@PerfilAluInd.requireContext()," reautenticado com sucesso",Toast.LENGTH_SHORT).show()
                }
            }

           user.currentUser!!.delete().addOnCompleteListener{ task ->
               if(task.isSuccessful){
                   Toast.makeText(this@PerfilAluInd.requireContext(),"Conta excluida com sucesso",Toast.LENGTH_SHORT).show()

               }else{
                   Toast.makeText(this@PerfilAluInd.requireContext(),task.exception.toString(),Toast.LENGTH_SHORT).show()
               }

           }

            val intent = Intent(this@PerfilAluInd.requireContext(), SplashScreenView::class.java)
            startActivity(intent)

        }

        return binding.root




    }


}