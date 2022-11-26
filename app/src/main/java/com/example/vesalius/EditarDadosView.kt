package com.example.vesalius

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.vesalius.databinding.ActivityEditarDadosViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storageMetadata
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.appbarprin.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class EditarDadosView : AppCompatActivity() {

    private lateinit var binding: ActivityEditarDadosViewBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var imgUri : Uri


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



        //fotoPerfil()

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

        }//fim bt salvar

        binding.btFoto.setOnClickListener {
            //selecionaImagem()
           // mandaImagem()

        }// fim bt foto

    }//fim on create

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

    private fun mandaImagem() {

        //progress bar
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Enviando imagen de perfil...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        //instancia
        val uid =  firebaseAuth.currentUser?.uid.toString()
        val fileName = uid
        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")
            storageReference.putFile(imgUri)
                .addOnSuccessListener {
                    binding.imgPerfil.setImageURI(imgUri)

                    Toast.makeText(this,"Imagem enviada com sucesso !!!",Toast.LENGTH_LONG).show()
                    if (progressDialog.isShowing) progressDialog.dismiss()

                }.addOnFailureListener{

                    if (progressDialog.isShowing) progressDialog.dismiss()
                    Toast.makeText(this,"Erro ao enviar !!",Toast.LENGTH_LONG).show()
                }

    }//fim manda imagem

    private fun selecionaImagem() {
        val REQUEST_CODE = 100
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }//fim seleciona Imagem

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 100 && resultCode == RESULT_OK){ imgUri = data?.data!!
          binding.imgPerfil.setImageURI(imgUri)

        }// fim if

    }//fim result

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