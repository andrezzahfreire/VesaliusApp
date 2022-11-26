package com.example.vesalius

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.WindowDecorActionBar
import com.example.vesalius.databinding.ActivityLoginViewBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginView : AppCompatActivity() {

    private  lateinit var  binding: ActivityLoginViewBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.azulquart)
        }


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

      //autenticação
      firebaseAuth = FirebaseAuth.getInstance()
      val db = FirebaseFirestore.getInstance()
      val uid =  firebaseAuth.currentUser?.uid.toString()
      db.collection("users").whereEqualTo("id",uid)
          .get()
          .addOnCompleteListener {
              val result : StringBuffer = StringBuffer ()
              //seleciona a tela que o usuario ira utilizar
              if (it.isSuccessful){
                  for(document in it.result !!) {
                     val tipo =  document.getString("tipo")
                      if(firebaseAuth.currentUser != null){
                          if(tipo.toString()=="Aluno Individual"){
                              val intent = Intent (this, HomeAlunoIndView::class.java)
                              startActivity(intent)
                              finish()
                          }else{
                              if(tipo.toString()=="Aluno Acompanhado"){
                              val intent = Intent (this, HomeAlunoAcomView::class.java)
                              startActivity(intent)
                              finish()
                          }else{
                                  val intent = Intent (this, HomeProfessorView::class.java)
                                  startActivity(intent)
                                  finish()
                          }

                          }

                      }
                  }

              }

          }


    }//fim on start

}// fim classe login