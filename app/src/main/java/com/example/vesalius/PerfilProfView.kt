package com.example.vesalius

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vesalius.databinding.ActivityHomeProfessorViewBinding
import com.example.vesalius.databinding.ActivityPerfilProfViewBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.appbarprin.*
import java.io.File

class PerfilProfView : AppCompatActivity() {
    private lateinit var user : FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityPerfilProfViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPerfilProfViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

       val tipo = intent.getStringExtra("tipo")

        firebaseAuth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val uid =  firebaseAuth.currentUser?.uid.toString()

        //fotoPerfil()

        db.collection("users").whereEqualTo("id",uid)
            .get()
            .addOnCompleteListener {

                val result : StringBuffer = StringBuffer ()

                if (it.isSuccessful){
                    for(document in it.result !!) {
                        binding.txtNomecomp.text = document.getString("nome").plus(" ").plus(document.getString("sobrenome"))
                        var txt : String = "Aluno de "
                        txt = if (tipo.equals("Aluno Acompanhado")  ) {
                            "Aluno de "

                        } else{
                            "Professor de "
                        }
                        binding.txtArea.text = txt.plus(document.getString("area"))
                        binding.txtEmailperfil.text = document.getString("email")
                    }

                }

            }


//vai editar dados
        binding.btIreditarperfil.setOnClickListener {
            val intent = Intent(this, EditarDadosView::class.java)
            startActivity(intent)
        }// fim botao

        // vai redefinir senha
        binding.btRedefinirsenha.setOnClickListener {
            val intent = Intent (this, RecuperarSenhaView :: class.java)
            startActivity(intent)
        }

        // vai pra saiba mais
        binding.btIrsaibamais.setOnClickListener {
            val intent = Intent (this, SaibaMaisVew ::class.java)
            startActivity(intent)
        }

        user = FirebaseAuth.getInstance()

        // logout da conta
        binding.btSairconta.setOnClickListener {
            user.signOut()
            val intent = Intent(this, LoginView::class.java)
            startActivity(intent)
            Toast.makeText(this,"Deslogado com sucesso", Toast.LENGTH_SHORT).show()
        }

        // deleta conta
        binding.btExcluirconta.setOnClickListener {
            val credential = EmailAuthProvider
                .getCredential("user@example.com", "password1234")

            user.currentUser!!.reauthenticate(credential).addOnCompleteListener {
                    task ->
                if(task.isSuccessful){
                    Toast.makeText(this," reautenticado com sucesso",
                        Toast.LENGTH_SHORT).show()
                }
            }
            db.collection("users").document(uid!!).delete().addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Conta excluida com sucesso",
                        Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"erro ao excluir conta",
                        Toast.LENGTH_SHORT).show()
                }
            }
            user.currentUser!!.delete().addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Conta excluida com sucesso",
                        Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(this,task.exception.toString(),
                        Toast.LENGTH_SHORT).show()
                }

            }

            val intent = Intent(this, SplashScreenView::class.java)
            startActivity(intent)

        }

    }

    private fun fotoPerfil() {
        val uid =  firebaseAuth.currentUser?.uid.toString()
        val imageName = uid
        val storageRef = FirebaseStorage.getInstance().getReference("images/$imageName")
        val localFile = File.createTempFile("tempImage","heic")
        storageRef.getFile(localFile).addOnSuccessListener {

            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
            binding.imgPerfil.setImageBitmap(bitmap)

        }.addOnFailureListener{
            Toast.makeText(this,"Erro ao recuperar !!",Toast.LENGTH_LONG).show()
        }//fim foto perfil
    }
}