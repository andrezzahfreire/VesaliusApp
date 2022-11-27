package com.example.vesalius

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vesalius.databinding.ActivityHomeProfessorViewBinding
import com.example.vesalius.fragments.bottonsheet.CriarSalaSheet
import com.example.vesalius.util.CustomAdapter
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import kotlinx.android.synthetic.main.appbarprin.*

class HomeProfessorView : AppCompatActivity() {

    private lateinit var binding: ActivityHomeProfessorViewBinding
    lateinit var recyclerView: RecyclerView
    private lateinit var salaArrayList: ArrayList<SalaModel>
    private lateinit var bd:FirebaseFirestore
    lateinit var  myadapter: CustomAdapter
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeProfessorViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Carregando dados")
        progressDialog.show()


        binding.btPerfil.setOnClickListener {
            val intent = Intent (this, PerfilProfView::class.java)
            startActivity(intent)
            // finish()
        }

        binding.btCriarsala.setOnClickListener {

            CriarSalaSheet().show(supportFragmentManager,"CriarSalaTag")

        }

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        bd = FirebaseFirestore.getInstance()

        val data = ArrayList<ItemsViewModel>()

        EventChangeListener()

    }

    private fun EventChangeListener() {

        bd.collection("salas").orderBy("turma",Query.Direction.ASCENDING)
            .addSnapshotListener {snapshot, e ->
               if (e!= null ){
                   if (progressDialog.isShowing){
                     progressDialog.dismiss()
                   }
                   Toast.makeText(this,"erro", Toast.LENGTH_SHORT).show()
                   return@addSnapshotListener
               }
                if (snapshot != null) {
                   // Toast.makeText(this,"deu certo", Toast.LENGTH_SHORT).show()
                    salaArrayList = arrayListOf(SalaModel())
                    for (dc :DocumentChange in snapshot.documentChanges){
                       if(dc.type == DocumentChange.Type.ADDED){

                           val doc = dc.document.toObject(SalaModel::class.java)
                           salaArrayList.add(dc.document.toObject(SalaModel :: class.java))
                           if (progressDialog.isShowing){
                               progressDialog.dismiss()
                           }
                       }
                    }
                    myadapter = CustomAdapter(salaArrayList)
                    recyclerView.adapter = myadapter
                }
            }
    }

    // função coloca fragmento na tela



}