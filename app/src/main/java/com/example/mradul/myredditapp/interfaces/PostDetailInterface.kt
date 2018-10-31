package com.example.mradul.myredditapp.interfaces

import com.example.mradul.myredditapp.presenters.PostDetailAll


interface PostDetailInterface {
    fun didRecieveResposne(data: Array<PostDetailAll>){

    }
    fun didReceiveError(error: String){

    }
}