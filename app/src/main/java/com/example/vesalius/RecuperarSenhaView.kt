package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.vesalius.databinding.ActivityRecuperarSenhaViewBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.appbar.*

class RecuperarSenhaView : AppCompatActivity() {

  private lateinit var binding: ActivityRecuperarSenhaViewBinding
  private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecuperarSenhaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Recuperar Senha")

        //firebase
        firebaseAuth = FirebaseAuth.getInstance()


        binding.btEnviar.setOnClickListener {
            val email = binding.edtEmailrep.toString()
            if(email.isEmpty()){
                Toast.makeText(this,"Coloque o email", Toast.LENGTH_SHORT).show()
            }else{
                firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Email enviado", Toast.LENGTH_SHORT).show()

                        }else{
                            Toast.makeText(this,task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                        }//fim else
                    }// fim listener
            }// fim else
        }// fim comfirmar

    }
}