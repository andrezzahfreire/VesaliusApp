package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vesalius.databinding.ActivityQuizAlunoAcompanhadoViewBinding
import com.example.vesalius.util.CustomAdapter

class QuizAlunoAcompanhadoView : AppCompatActivity() {
    lateinit var binding: ActivityQuizAlunoAcompanhadoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizAlunoAcompanhadoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview_quiz)
        val recyclerview2 = findViewById<RecyclerView>(R.id.recyclerview2_quiz)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview2.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view

        /*for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.area, "Item " + i))
        }
*/
        // This will pass the ArrayList to our Adapter

       // val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
      //  recyclerview.adapter = adapter
       // recyclerview2.adapter = adapter

    }
}