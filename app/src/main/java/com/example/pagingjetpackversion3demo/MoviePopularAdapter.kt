package com.example.pagingjetpackversion3demo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviePopularAdapter: PagingDataAdapter<ListMoviePopular, MoviePopularAdapter.MovieViewHolder>(DiffUtilCallBack()) {

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var imgPoster: ImageView = view.findViewById(R.id.img_poster)
        private var tvTitle: TextView = view.findViewById(R.id.tv_title)
        fun bind(data: ListMoviePopular) {
            tvTitle.text = data.title
            Glide.with(imgPoster).load(data.getImagePosterPathPopular()).into(imgPoster)
            Log.d("123123", "id ${data.id}")
        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<ListMoviePopular>() {
        override fun areItemsTheSame(oldItem: ListMoviePopular, newItem: ListMoviePopular): Boolean {
            //return oldItem.title == newItem.title
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ListMoviePopular, newItem: ListMoviePopular): Boolean {
            return when {
                oldItem.id != newItem.id -> {
                    false
                }
                oldItem.title != newItem.title -> {
                    false
                }
                oldItem.getImagePosterPathPopular() != newItem.getImagePosterPathPopular() -> {
                    false
                }
                else -> true
            }
        }
    }

/*    class Diff(private val oldList: List<ListMoviePopular>, private val newList: List<ListMoviePopular>): DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return when {
                oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                    false
                }
                oldList[oldItemPosition].title != newList[newItemPosition].title -> {
                    false
                }
                oldList[oldItemPosition].getImagePosterPathPopular() != newList[newItemPosition].getImagePosterPathPopular() -> {
                    false
                }
                else -> true
            }
        }
    }*/

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }
}