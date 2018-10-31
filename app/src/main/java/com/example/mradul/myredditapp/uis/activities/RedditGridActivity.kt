package com.example.mradul.myredditapp.uis.activities

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.example.mradul.myredditapp.R
import com.example.mradul.myredditapp.adapters.GridViewAdapter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_reddit_grid.*
import okhttp3.*
import java.io.IOException

class RedditGridActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reddit_grid)

        var token = getSharedPreferences("username", Context.MODE_PRIVATE)

        setSupportActionBar(action_bar as Toolbar?)
        supportActionBar!!.setSubtitle(token.getString("logged_username", " "))

//        grid_view.setBackgroundColor(Color.BLUE)
        grid_view.layoutManager = LinearLayoutManager(this)
//        grid_view.adapter = GridViewAdapter()
        fetchJson()

    }

    fun fetchJson(){
        println("Attempting to Fetch JSON")

        val url = "https://www.reddit.com/r/all.json"

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val redditAll = gson.fromJson(body, RedditAll::class.java)
                runOnUiThread {
                    grid_view.adapter = GridViewAdapter(redditAll)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }


        })
    }
}

class RedditAll(val data: RedditData)

class RedditData(val children: List<Child>)

class Child(val data: ChildData)

class ChildData(val thumbnail: String, val title: String, val author: String, val permalink: String)