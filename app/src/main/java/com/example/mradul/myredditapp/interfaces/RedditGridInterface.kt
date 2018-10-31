package com.example.mradul.myredditapp.interfaces


import com.example.mradul.myredditapp.models.RedditGridModels.RedditAll

interface RedditGridInterface {

    fun didRecieveResposne(data: RedditAll){

    }
    fun didReceiveError(error: String){

    }
}
