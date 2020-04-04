package com.cutedev.basketscore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private var team1Name : String? = null
    private var team2Name : String? = null
    private var scoreTeam1: Int = 0
    private var scoreTeam2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setUp()
    }

    private fun setUp(){
        team1Name = intent.getStringExtra("team1Name")
        team2Name = intent.getStringExtra("team2Name")
        scoreTeam1 = intent.getIntExtra("scoreTeam1", 0)
        scoreTeam2 = intent.getIntExtra("scoreTeam2", 0)

        txt_team1.text = team1Name
        txt_team2.text = team2Name
        txt_score_team1.text = scoreTeam1.toString()
        txt_score_team2.text = scoreTeam2.toString()

        if (scoreTeam1 == scoreTeam2){
            txt_team1.setTextColor(ContextCompat.getColor(this, R.color.colorDraw))
            txt_team2.setTextColor(ContextCompat.getColor(this, R.color.colorDraw))
            txt_score_team1.setTextColor(ContextCompat.getColor(this, R.color.colorDraw))
            txt_score_team2.setTextColor(ContextCompat.getColor(this, R.color.colorDraw))

        } else if (scoreTeam1 > scoreTeam2){
            txt_team1.setTextColor(ContextCompat.getColor(this, R.color.colorWin))
            txt_team2.setTextColor(ContextCompat.getColor(this, R.color.colorLose))
            txt_score_team1.setTextColor(ContextCompat.getColor(this, R.color.colorWin))
            txt_score_team2.setTextColor(ContextCompat.getColor(this, R.color.colorLose))
        } else {
            txt_team1.setTextColor(ContextCompat.getColor(this, R.color.colorLose))
            txt_team2.setTextColor(ContextCompat.getColor(this, R.color.colorWin))
            txt_score_team1.setTextColor(ContextCompat.getColor(this, R.color.colorLose))
            txt_score_team2.setTextColor(ContextCompat.getColor(this, R.color.colorWin))
        }

        btn_match_new.setOnClickListener{
            val intent = MainActivity.newIntent(this)
            startActivity(intent)
            finish()
        }
    }

    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, ResultActivity::class.java)
        }
    }
}
