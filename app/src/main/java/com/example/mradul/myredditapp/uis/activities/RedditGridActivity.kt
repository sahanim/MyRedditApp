package com.example.mradul.myredditapp.uis.activities

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.example.mradul.myredditapp.R
import com.example.mradul.myredditapp.adapters.GridViewAdapter
import com.example.mradul.myredditapp.interfaces.RedditGridInterface
import com.example.mradul.myredditapp.models.RedditGridModels.RedditAll
import com.example.mradul.myredditapp.presenters.RedditGridPresenter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_reddit_grid.*
import okhttp3.*
import java.io.IOException
class RedditGridActivity: AppCompatActivity(), RedditGridInterface {

    val redditGridPresenter = RedditGridPresenter(this)
    override fun didReceiveError(error: String) {
        //todo: stop progress bar
    }

    override fun didRecieveResposne(data: RedditAll) {
        //todo: stop progress bar
         runOnUiThread {
            grid_view.adapter = GridViewAdapter(data)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reddit_grid)

        var token = getSharedPreferences("username", Context.MODE_PRIVATE)

        setSupportActionBar(action_bar as Toolbar?)
        supportActionBar!!.setSubtitle(token.getString("logged_username", " "))

        grid_view.layoutManager = LinearLayoutManager(this)

        redditGridPresenter.fetchJson()
    }
}

