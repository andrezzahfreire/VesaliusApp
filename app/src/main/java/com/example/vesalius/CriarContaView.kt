package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vesalius.databinding.ActivityCriarContaViewBinding
import com.example.vesalius.databinding.ActivityLoginViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class CriarContaView : AppCompatActivity() {

    private lateinit var binding: ActivityCriarContaViewBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCriarContaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

     // recebe o tipo de usuário


      // coloca o tipo de usario
        binding.txtTipo.text = intent.getStringExtra("tipo")


        binding.btVoltarlogin.setOnClickListener {
            val intent = Intent(this, LoginView::class.java)
            startActivity(intent)
            finish()
        }

        binding.btCriarconta.setOnClickListener {

                val nome = binding.edtNome.text.toString()
                val sobrenome = binding.edtSobrenome.text.toString()
                val email = binding.edtEmail.text.toString()
                val senha = binding.edtSenha.text.toString()
                val repsenha = binding.edtRepsenha.text.toString()
                val area = binding.edtArea.text.toString()
                val tipo = binding.txtTipo.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty() && repsenha.isNotEmpty()){
                  if (senha == repsenha){
                      firebaseAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
                          if(it.isSuccessful){
                              salvarUsu(nome,sobrenome,email,senha,area,tipo)
                            val intent = Intent(this, LoginView::class.java)
                              startActivity(intent)
                              finish()
                          }else{
                              Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                          }// fim else
                      } //fim if
                }else{
                     Toast.makeText(this,"Senhas diferentes",Toast.LENGTH_SHORT).show()
                  }//fim else
            }else{
                Toast.makeText(this,"Preencha os campos corretamente",Toast.LENGTH_SHORT).show()
            }
        }//fim on click

    }// fim on create

    fun salvarUsu (nome:String,sobrenome:String,email :String,senha :String,area :String ,tipo :String){
       val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String,Any> = HashMap()
        user ["nome"] = nome
        user ["sobrenome"] = sobrenome
        user ["email"] = email
        user ["senha"] = senha
        user ["area"] = area
        user ["tipo"] = tipo

        db.collection("users")
            .add(user)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    Toast.makeText(this, " Conta criada com sucesso",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, task.exception.toString(),Toast.LENGTH_SHORT).show()
                }

            }
    }
}// fim classe