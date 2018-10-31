package com.example.mradul.myredditapp.uis.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mradul.myredditapp.R
import com.example.mradul.myredditapp.adapters.holders.CustomViewHolder
import com.example.mradul.myredditapp.interfaces.PostDetailInterface
import com.example.mradul.myredditapp.presenters.PostDetailAll
import com.example.mradul.myredditapp.presenters.PostDetailPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post_detail.*
class PostDetailActivity : PostDetailInterface,  AppCompatActivity() {

    val postDetailPresenter = PostDetailPresenter(this)

    var baseUrl: String = "https://www.reddit.com"

    override fun didReceiveError(error: String) {
        //todo: stop progress bar
        // display error
    }

    override fun didRecieveResposne(data: Array<PostDetailAll>) { //need data
        //todo: stop progress bar

        runOnUiThread {
            reddit_post_title.setText(data[0].data.children[0].data.title)
            reddit_post_author.setText(data[0].data.children[0].data.author)
            reddit_post_body.setText(data[0].data.children[0].data.body)
            Picasso.get().load(data[0].data.children[0].data.preview.images[0].source.url).into(image_view)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
        val permalink = intent.getStringExtra(CustomViewHolder.PERMALINK_URL_KEY)
        postDetailPresenter.fetchJson(baseUrl + permalink + ".json")
        //todo: start progress bar
    }

}

