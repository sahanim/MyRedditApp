package com.example.mradul.myredditapp.presenters

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v4.content.ContextCompat.startActivity
import com.example.mradul.myredditapp.uis.activities.RedditGridActivity

class LoginPresenter {

    private var context: Context?

    private var prefs: SharedPreferences?
    constructor(context: Context){
        this.context = context
        prefs = context.getSharedPreferences("username", Context.MODE_PRIVATE)
    }
//    SharedPreferences preferences = "username"


    fun loginWithUsername(username: String){
        var editor = prefs!!.edit()
        editor.putString("logged_username", username)
        editor.commit()
    }

    fun isUserLoggedIn() : Boolean{
        if(prefs!!.getString("logged_username", " ") != " "){
            return true
        }else{
            return false
        }
    }

}