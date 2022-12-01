package com.example.vesalius

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vesalius.databinding.ActivityHomeAlunoAcomViewBinding
import com.example.vesalius.util.CustomAdapter
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.appbarprin.*

class HomeAlunoAcomView : AppCompatActivity() {
    private lateinit var binding: ActivityHomeAlunoAcomViewBinding
    private lateinit var bd: FirebaseFirestore
    lateinit var progressDialog: ProgressDialog
    private lateinit var salaArrayList: ArrayList<SalaModel>
    lateinit var  myadapter: CustomAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeAlunoAcomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Carregando dados")
        progressDialog.show()

        binding.btPerfil.setOnClickListener {
            val intent = Intent (this, PerfilProfView::class.java)
            intent.putExtra("tipo","Aluno Acompanhado")
            startActivity(intent)

            finish()
        }

        // getting the recyclerview by its id
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        bd = FirebaseFirestore.getInstance()
        val data = ArrayList<ItemsViewModel>()
        EventChangeListener()


     binding.btEntrarSala.setOnClickListener {
             val intent = Intent(this,CodigoSalaView::class.java)
            startActivity(intent)
        }

    }// fim on create

    private fun EventChangeListener() {

        bd.collection("salas").orderBy("turma", Query.Direction.ASCENDING)
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
                    for (dc : DocumentChange in snapshot.documentChanges){
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

}// fim home aluno