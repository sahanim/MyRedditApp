package com.example.mradul.myredditapp.presenters

import com.example.mradul.myredditapp.interfaces.PostDetailInterface

class PostDetailPresenter {

    constructor(APIinterface: PostDetailInterface){
        this.api_interface = APIinterface
    }

    var api_interface: PostDetailInterface?

    fun fetchData(){
        //call network manager method
        // if it returns the data convert into a GSON object and send it back to didRecieveResponse

        //this.api_interface!!.didRecieveResposne()

        //if error
        //this.api_interface!!.didReceiveError("Error") //error from network manager


    }



    //methods to expose the data
}