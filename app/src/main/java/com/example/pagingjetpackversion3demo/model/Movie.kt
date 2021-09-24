package com.example.pagingjetpackversion3demo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var results: List<ListMoviePopular>,
)

data class ListMoviePopular(
    @SerializedName("title")
    var title: String,
    @SerializedName("poster_path")
    var posterPath: String
) : Serializable {
    fun getImagePosterPathPopular(): String {
        return "https://image.tmdb.org/t/p/w500/$posterPath"
    }

}

