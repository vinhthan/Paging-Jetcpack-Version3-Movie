package com.example.pagingjetpackversion3demo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingjetpackversion3demo.network.RetrofitService

class MoviePagingSource(private val apiService: RetrofitService): PagingSource<Int, ListMoviePopular>() {
    companion object{
        private const val FIRST_PAGE = 1;
    }

    override fun getRefreshKey(state: PagingState<Int, ListMoviePopular>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListMoviePopular> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE
            val response = apiService.getMoviePopular("034bbd1b233d6726e0c7dc7f338657f9", nextPage)

            LoadResult.Page(data = response.results, prevKey = null, nextKey = response.page + 1)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}