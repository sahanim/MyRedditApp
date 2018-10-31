package com.example.mradul.myredditapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.mradul.myredditapp.R
import com.example.mradul.myredditapp.uis.activities.RedditAll
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.grid_item_layout.view.*

class GridViewAdapter(val redditAll: RedditAll) : RecyclerView.Adapter<CustomViewHolder>() {

    val postTitles = listOf("First", "Second", "Third", "More")

    //numberOfItems
    override fun getItemCount(): Int {
        return redditAll.data.children.count()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        //create view
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.grid_item_layout, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        val child = redditAll.data.children.get(p1)

        p0.view.reddit_post_title.text = child.data.title
        p0.view.reddit_post_author.text = child.data.author


        val thumbnailImageView = p0.view.grid_image_view
        Picasso.get().load(child.data.thumbnail).into(thumbnailImageView)
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}