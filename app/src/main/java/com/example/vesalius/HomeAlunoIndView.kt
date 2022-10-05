package com.example.vesalius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.vesalius.databinding.ActivityHomeAlunoAcomViewBinding
import com.example.vesalius.databinding.ActivityHomeAlunoIndViewBinding
import com.example.vesalius.fragments.HomeAlunoInd
import com.example.vesalius.fragments.PerfilAluInd
import com.example.vesalius.fragments.QuizAlunoInd
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home_aluno_ind_view.*
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.appbarprin.*

class HomeAlunoIndView : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityHomeAlunoIndViewBinding
   // inicializa os fragmetos

    private val homeAlunoInd = HomeAlunoInd()
    private val perfilAlunoInd = PerfilAluInd()
    private val quizAlunoInd = QuizAlunoInd()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeAlunoIndViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // bt action bar
        setSupportActionBar(toolbarprin)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        replaceFragment(HomeAlunoInd())


        binding.bottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.bt_home -> replaceFragment(HomeAlunoInd())
                R.id.bt_user-> replaceFragment(PerfilAluInd())
                R.id.bt_question -> replaceFragment(QuizAlunoInd())

                else -> {

                }//fim else


            }// fim when

            true
        }

    }// fim on create

    // função coloca fragmento na tela
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transition = supportFragmentManager.beginTransaction()
            transition.replace(R.id.fragment_container,fragment)
            transition.commit()
        }//fim if

    }// fim função

}// fim home aluno