package com.example.mradul.myredditapp.presenters

import com.example.mradul.myredditapp.interfaces.PostDetailInterface
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class PostDetailPresenter {
    constructor(APIinterface: PostDetailInterface) {
        this.api_interface = APIinterface
    }

    var api_interface: PostDetailInterface?



    fun fetchJson(url:String) {
        println("Attempting to Fetch Json")

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                api_interface!!.didReceiveError("Error") //get error from exception
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val postDetailAll = gson.fromJson(body, Array<PostDetailAll>::class.java)
                api_interface!!.didRecieveResposne(postDetailAll)
            }
        })
        //get intent
    }
}

class PostDetailAll(val data: PostDetailDataChild)
class PostDetailDataChild(val children: List<PostDetailChild>)
class PostDetailChild(val data: PostDetailChildData)
class PostDetailChildData(val preview: Preview, val title: String, val author: String, val body: String)
class Preview(val images: List<ChildDataImage>)
class ChildDataImage(val source: ImageSource)
class ImageSource(val url: String)