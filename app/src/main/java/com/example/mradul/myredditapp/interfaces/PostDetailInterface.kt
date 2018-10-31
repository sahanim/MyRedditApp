package com.example.mradul.myredditapp.interfaces

import com.example.mradul.myredditapp.models.PostDetailObject

interface PostDetailInterface {
    fun didRecieveResposne(data: PostDetailObject){

    }
    fun didReceiveError(error: String){

    }
}