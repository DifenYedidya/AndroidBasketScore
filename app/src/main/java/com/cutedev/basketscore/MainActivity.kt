package com.cutedev.basketscore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
    }

    private fun setUp(){
        btn_match_start.setOnClickListener {

            //get edit text team 1 name
            val team1Name = ed_team1.text.toString()

            //get edit text team 2 name
            val team2Name = ed_team2.text.toString()

            //buat nampilin sekilas text klo kita klik tombolnya
//            Toast.makeText(this, " Team 1 : $team1Name\nTeam 2 : $team2Name",
//            Toast.LENGTH_SHORT).show()

            if(validate(team1Name, team2Name)){

                val intent = MatchActivity.newIntent(this)

                //passing nilai ke dalam intent
                intent.putExtra("team1", team1Name)
                intent.putExtra("team2", team2Name)

                startActivity(intent)
                finish()
            }
        }
    }

    private fun validate(team1 : String, team2 : String): Boolean{
        var errorCount = 0
        if(team1.isEmpty()){
            errorCount++
            ed_team1.error = "Harap isi kolom ini"
        } else {
            ed_team1.error = null
        }

        if(team2.isEmpty()){
            errorCount++
            ed_team2.error = "Harap isi kolom ini"
        } else {
            ed_team2.error = null
        }
        return errorCount == 0
    }

    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
