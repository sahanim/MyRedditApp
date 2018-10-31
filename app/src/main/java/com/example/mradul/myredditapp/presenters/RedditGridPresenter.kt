package com.example.mradul.myredditapp.presenters

import com.example.mradul.myredditapp.R.id.grid_view
import com.example.mradul.myredditapp.adapters.GridViewAdapter
import com.example.mradul.myredditapp.interfaces.PostDetailInterface
import com.example.mradul.myredditapp.interfaces.RedditGridInterface
import com.example.mradul.myredditapp.models.RedditGridModels.RedditAll
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_reddit_grid.*
import okhttp3.*
import java.io.IOException

class RedditGridPresenter {


    constructor(APIinterface: RedditGridInterface){
        this.api_interface = APIinterface
    }

    var api_interface: RedditGridInterface?

    fun fetchJson(){
        println("Attempting to Fetch JSON")
        val url = "https://www.reddit.com/r/all.json"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                api_interface!!.didReceiveError("Error") // get error from exception
                println("Failed to execute request")
            }
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val redditAll = gson.fromJson(body, RedditAll::class.java)
                api_interface!!.didRecieveResposne(redditAll)
            }
        })
    }

}