package com.example.vesalius

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.vesalius.databinding.ActivityTipoContaViewBinding
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.appbarprin.*


class TipoContaView : AppCompatActivity() {

    private lateinit var  binding: ActivityTipoContaViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTipoContaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tipo = Intent(this,CriarContaView::class.java)

        binding.btTipoaluno.setOnClickListener {
            val intent = Intent(this,TipoContaAlunoView::class.java)
            startActivity(intent)
        }

        binding.btTipoprof.setOnClickListener {
            val intent = Intent(this,CriarContaView::class.java)
            intent.putExtra("tipo","Professor")
            startActivity(intent)
            finish()
        }


    }// fim on create


}// fim classe Tipo