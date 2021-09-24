package com.example.pagingjetpackversion3demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingjetpackversion3demo.network.RetrofitInstance
import com.example.pagingjetpackversion3demo.network.RetrofitService
import kotlinx.coroutines.flow.Flow

class MovieViewModel: ViewModel() {
    var retrofitService: RetrofitService = RetrofitInstance().getRetrofitInstance().create(RetrofitService::class.java)

    fun getListMoviePopular(): Flow<PagingData<ListMoviePopular>> {
        return Pager(config = PagingConfig(pageSize = 500, prefetchDistance = 20),
        pagingSourceFactory = {MoviePagingSource(retrofitService)}).flow.cachedIn(viewModelScope)
    }
}