package com.example.pagingjetpackversion3demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest

class MovieActivity : AppCompatActivity() {
    lateinit var mAdapter: MoviePopularAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        rcy_movie.apply {
            layoutManager = LinearLayoutManager(this@MovieActivity)
            hasFixedSize()
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            mAdapter = MoviePopularAdapter()
            adapter = mAdapter
        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        lifecycleScope.launchWhenCreated {
            viewModel.getListMoviePopular().collectLatest {
                mAdapter.submitData(it)
            }
        }
    }
}

