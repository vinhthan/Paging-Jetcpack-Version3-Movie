package com.example.pagingjetpackversion3demo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private const val baseUrl = "https://api.themoviedb.org/3/movie/"
    }

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

//{movie_id}: 157336
//api key: 034bbd1b233d6726e0c7dc7f338657f9
//url: https://api.themoviedb.org/3/movie/popular?api_key=034bbd1b233d6726e0c7dc7f338657f9&page=1
//url detail: https://api.themoviedb.org/3/movie/497698?api_key=034bbd1b233d6726e0c7dc7f338657f9
//poster: https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg

//key video: 5lGoQhFb4NM
//video: https://www.youtube.com/watch?v=5lGoQhFb4NM

//image from youtube: https://i3.ytimg.com/vi/5lGoQhFb4NM/hqdefault.jpg  //5lGoQhFb4NM is key video

//login
//api_key 034bbd1b233d6726e0c7dc7f338657f9
//username thanmanhvinh
//password vinhmcmvc
//request_token c4d1514744c59f936df788570de331dd786a4a69 //co han sd

//logout
//api_key 034bbd1b233d6726e0c7dc7f338657f9
//"session_id": "2629f70fb498edc263a0adb99118ac41f0053e8c"
//