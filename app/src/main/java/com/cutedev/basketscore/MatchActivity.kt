package com.cutedev.basketscore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.txt_team1
import kotlinx.android.synthetic.main.activity_main.txt_team2
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity() {

    private var team1Name : String? = null
    private var team2Name : String? = null
    private var scoreTeam1: Int = 0
    private var scoreTeam2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        setUp()
    }

    private fun setUp(){
        team1Name = intent.getStringExtra("team1")
        team2Name = intent.getStringExtra("team2")

        txt_team1.text = team1Name
        txt_team2.text = team2Name

        txt_score_team1.text = scoreTeam1.toString()
        txt_score_team2.text = scoreTeam2.toString()

        btn_match_finish.setOnClickListener{
            val intent = ResultActivity.newIntent(this)
            intent.apply {
                putExtra("team1Name", team1Name)
                putExtra("team2Name", team2Name)
                putExtra("scoreTeam1", scoreTeam1)
                putExtra("scoreTeam2", scoreTeam2)
            }

            startActivity(intent)
            finish()
        }
    }

    fun plus1Team1(view: View) {
        scoreTeam1 += 1
        txt_score_team1.text = scoreTeam1.toString()
    }

    fun plus2Team1(view: View) {
        scoreTeam1 += 2
        txt_score_team1.text = scoreTeam1.toString()
    }

    fun plus3Team1(view: View) {
        scoreTeam1 += 3
        txt_score_team1.text = scoreTeam1.toString()
    }

    fun plus1Team2(view: View) {
        scoreTeam2 += 1
        txt_score_team2.text = scoreTeam2.toString()
    }

    fun plus2Team2(view: View) {
        scoreTeam2 += 2
        txt_score_team2.text = scoreTeam2.toString()
    }

    fun plus3Team2(view: View) {
        scoreTeam2 += 3
        txt_score_team2.text = scoreTeam2.toString()
    }

    companion object{
        fun newIntent(context: Context) : Intent {
            return Intent(context, MatchActivity::class.java)
        }
    }


}
