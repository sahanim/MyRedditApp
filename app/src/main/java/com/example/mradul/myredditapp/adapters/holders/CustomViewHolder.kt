package com.example.mradul.myredditapp.adapters.holders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.mradul.myredditapp.uis.activities.LoginActivity
import com.example.mradul.myredditapp.uis.activities.PostDetailActivity

class CustomViewHolder(val view: View, var permalink_url: String? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val PERMALINK_URL_KEY = "PERMALINK_URL"
    }
    init {
        view.setOnClickListener {
            println("TEST")

            val intent = Intent(view.context, PostDetailActivity::class.java)

            intent.putExtra(PERMALINK_URL_KEY, permalink_url)

            view.context.startActivity(intent)
        }
    }

}