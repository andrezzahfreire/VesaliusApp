package com.example.vesalius

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_on_board_view.*
import me.relex.circleindicator.CircleIndicator3
import java.lang.Boolean

private var detailsList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
  private var prevStarted = "prevStarted"
class OnBoardView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board_view)

        postToList()

        view_pager2.adapter = ViewPagerAdapter(detailsList, imagesList)
        view_pager2.orientation=ViewPager2.ORIENTATION_HORIZONTAL

        var idt = 0;

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)

        bt_fake_swipe.setOnClickListener {
            val intent = Intent(this, LoginView ::class.java)
            startActivity(intent)
            finish()
        }
        bt_passar.setOnClickListener{
             idt ++
            view_pager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }//fim apply
            if (idt == 6){
                val intent = Intent(this, LoginView ::class.java)
                startActivity(intent)
                finish()
            }
        }// fim on click

    }//fim on create

    private fun addToList(details: String, image: Int){
      detailsList.add(details)
        imagesList.add(image)

    }// fim add to list

    private fun postToList(){

        addToList( "Seja bem-vindo a plataforma que vai fazer você aprender a anatomia humana",
            R.drawable.board1
        )// fim add

        addToList("Aqui você poderá aprender sobre o corpo humano de uma forma divertida",
            R.drawable.board7
        )// fim add

        addToList("Utilizando a realidade aumentada para visualizar ",
            R.drawable.board2
        )// fim add

        addToList("Listas e quizes para exercitar",
            R.drawable.board3
        )// fim add

        addToList("Além disso, você poderá visualizar as principais doenças em realidade aumentada. Legal né?  ",
            R.drawable.board4
        )// fim add

        addToList("Vamos começar?",
            R.drawable.board6
        )//fim add

    }// fim post to list

    override fun onResume() {
        super.onResume()
        val sharedpreferences =  getSharedPreferences(getString(applicationInfo.labelRes), MODE_PRIVATE)
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            val editor = sharedpreferences.edit()
            editor.putBoolean(prevStarted, Boolean.TRUE)
            editor.apply()
        } else {
            val intent = Intent(this,LoginView::class.java)
            startActivity(intent)
            finish()
        }
    }
}// fim onBoard view