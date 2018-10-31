package com.example.mradul.myredditapp.uis.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mradul.myredditapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var token = getSharedPreferences("username", Context.MODE_PRIVATE)

        if(token.getString("logged_username", " ") != " "){
            var intent = Intent(this, RedditGridActivity::class.java)
            startActivity(intent)
            finish()
        }
        button.setOnClickListener {
            //todo: check if null
            var username = app_user_name.text.toString()

            var intent = Intent(this, RedditGridActivity::class.java)
                intent.putExtra("username", username)

            var editor = token.edit()
            editor.putString("logged_username", username)
            editor.commit()
            startActivity(intent)
        }
    }
}
