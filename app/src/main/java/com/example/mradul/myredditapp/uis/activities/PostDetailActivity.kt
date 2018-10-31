package com.example.mradul.myredditapp.uis.activities

import com.example.mradul.myredditapp.interfaces.PostDetailInterface
import com.example.mradul.myredditapp.models.PostDetailObject

class PostDetailActivity : PostDetailInterface {

    val PostDetailPresenter = com.example.mradul.myredditapp.presenters.PostDetailPresenter(this)

    override fun didReceiveError(error: String) {
        // stop progress bar
        // display error
    }

    override fun didRecieveResposne(data: PostDetailObject) {
        // stop progress bar
        // reload grid layout
        // grid layout will ask for data
        // send model back and treat like normal




    }

    // oncreate
    // fetch data of presenter and start progress bar
    // o



}