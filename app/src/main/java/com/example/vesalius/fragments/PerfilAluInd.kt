package com.example.vesalius.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.example.vesalius.*
import com.example.vesalius.databinding.FragmentPerfilAluIndBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilAluInd : Fragment() {

    private lateinit var user : FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentPerfilAluIndBinding.inflate(layoutInflater)
       /* firebaseAuth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val uid =  firebaseAuth.currentUser?.uid.toString()
         db.collection("users").whereEqualTo("id",uid)
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

*/
        val db = FirebaseFirestore.getInstance()
        var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val uid =  firebaseAuth.currentUser?.uid.toString()


        //campos
        var nome = " "
        var area = " "
        var email = " "
        var sobrenome = " "

        db.collection("users").document(uid).get()

            .addOnSuccessListener {
                nome  = it.get("nome") as String
                sobrenome  = it.get("sobrenome") as String
                area  = it.get("area") as String
                email  = it.get("email") as String

                binding.txtNomecomp.text = nome.plus(" ").plus(sobrenome)
                var txt : String = "Estudante de "
                binding.txtArea.text = txt.plus(area)
                binding.txtEmailperfil.text = email
            }
            .addOnFailureListener {
                Toast.makeText(this@PerfilAluInd.requireContext(),"Erro ao receber",Toast.LENGTH_SHORT).show()
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
            db.collection("users").document(uid!!).delete().addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this@PerfilAluInd.requireContext(),"Conta excluida com sucesso",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@PerfilAluInd.requireContext(),"erro ao excluir conta",Toast.LENGTH_SHORT).show()
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

fun getFirestore(collect : String){


}//fim pegar