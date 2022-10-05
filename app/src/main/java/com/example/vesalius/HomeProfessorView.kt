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



      //  val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        bd = FirebaseFirestore.getInstance()


        // this creates a vertical layout Manager
       // recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel

        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view

        /*
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.area, "Item " + i))
        }
        */

        // This will pass the ArrayList to our Adapter
       // val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
       //    recyclerview.adapter = adapter

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
                    Toast.makeText(this,"deu certo", Toast.LENGTH_SHORT).show()
                    salaArrayList = arrayListOf(SalaModel())

                    for (dc :DocumentChange in snapshot.documentChanges){
                       if(dc.type == DocumentChange.Type.ADDED){

                           val doc = dc.document.toObject(SalaModel::class.java)
                           salaArrayList.add(dc.document.toObject(SalaModel :: class.java))

                           Toast.makeText(this,"foi", Toast.LENGTH_SHORT).show()
                              println(salaArrayList.toString())
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