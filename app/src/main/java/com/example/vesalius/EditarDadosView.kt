package com.example.vesalius

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.vesalius.databinding.ActivityEditarDadosViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.appbarprin.*

class EditarDadosView : AppCompatActivity() {

    private lateinit var binding: ActivityEditarDadosViewBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bt voltar action bar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // set binding
        binding = ActivityEditarDadosViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val uid =  firebaseAuth.currentUser?.uid.toString()

        //opcoes de areas
        val areas = resources.getStringArray(R.array.areas)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, areas)
        // get reference to the autocomplete text view
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.edt_area)
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)

      /* db.collection("users").whereEqualTo("id",uid)
            .get()
            .addOnCompleteListener {

                val result : StringBuffer = StringBuffer ()

                if (it.isSuccessful){
                    for(document in it.result !!) {
                        binding.nomeEdt.setText(document.getString("nome"))
                        binding.sobreEdt.setText(document.getString("sobrenome"))
                        binding.emailEdt.setText(document.getString("email"))
                        binding.edtArea.setText(document.getString("area"))
                    }

                }

            }


        */


        var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

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

                binding.nomeEdt.setText(nome)
                binding.sobreEdt.setText(sobrenome)
                binding.emailEdt.setText(email)
                binding.edtArea.setText(area)
            }
            .addOnFailureListener {
                Toast.makeText(this,"Erro ao receber",Toast.LENGTH_SHORT).show()
            }


        binding.btSalvar.setOnClickListener {

            var nome =  binding.nomeEdt.text.toString()
            var sobrenome =binding.sobreEdt.text.toString()
            var email  = binding.emailEdt.text.toString()
            var area = binding.edtArea.text.toString()
            saveFirestore(nome, sobrenome, email, area)
            Toast.makeText(this,"Atualizado com sucesso",Toast.LENGTH_LONG).show()
            /* var dado = hashMapOf<String,Any>(
                 "nome" to nome,
                 "sobrenome" to sobrenome,
                 "email" to email,
                 "area" to area,
                 )
             db.collection("users").document(uid).update(dado).addOnCompleteListener {
                 if(it.isSuccessful){
                     Toast.makeText(this,"Atualizado com sucesso",Toast.LENGTH_LONG).show()
                 }
             }*/
        }


        // instancia firebase

    }//fim on create
}// fim editar dados

fun saveFirestore(nome:String,sobrenome : String, email: String, area : String){
    val db = FirebaseFirestore.getInstance()

    var firebaseAuth: FirebaseAuth  = FirebaseAuth.getInstance()
    val uid =  firebaseAuth.currentUser?.uid.toString()

    db.collection("users").document(uid).update("nome",nome)
    db.collection("users").document(uid).update("sobrenome",sobrenome)
    db.collection("users").document(uid).update("email",email)
    db.collection("users").document(uid).update("area",area)

}//fim save