package com.example.mradul.myredditapp.uis.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mradul.myredditapp.R
import com.example.mradul.myredditapp.presenters.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var loginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this)
        if(loginPresenter!!.isUserLoggedIn()){
            var intent = Intent(this, RedditGridActivity::class.java)
            startActivity(intent)
            finish()
        }

        button.setOnClickListener {
            var username = app_user_name.text.toString()
            if(username != " "){
                loginPresenter!!.loginWithUsername(username)
                var intent = Intent(this, RedditGridActivity::class.java)
                //intent.putExtra("username", username)
                startActivity(intent)
            }else{
                //show error -> empty username
            }
        }
    }
}
