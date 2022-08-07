package com.example.vesalius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.WindowDecorActionBar
import com.example.vesalius.databinding.ActivityLoginViewBinding
import com.google.firebase.auth.FirebaseAuth

class LoginView : AppCompatActivity() {

    private  lateinit var  binding: ActivityLoginViewBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btIrcriarconta.setOnClickListener {
            val intent = Intent(this,TipoContaView::class.java)
            startActivity(intent)
        }

        binding.btLogar.setOnClickListener {
            val email = binding.edtEmaillogin.text.toString()
            val senha = binding.edtSenhalogin.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty() ){

                    firebaseAuth.signInWithEmailAndPassword(email,senha).addOnCompleteListener {
                        if(it.isSuccessful){

                            val intent = Intent(this, HomeAlunoIndView::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"Email ou senha incorretos", Toast.LENGTH_SHORT).show()
                        }// fim else
                    } //fim if
            }else{
                Toast.makeText(this,"Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            }// fim else

        }// fim on click

        binding.btEsquesenha.setOnClickListener {
            val intent = Intent(this,RecuperarSenhaView::class.java)
            startActivity(intent)
        }
    }// fim on create

  // mantem o usuario logado
    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
            val intent = Intent (this, HomeAlunoIndView::class.java)
            startActivity(intent)
            finish()
        }
    }//fim on start

}// fim classe login