package com.example.popularmovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder> {

    private lateinit var mContext:Context
    private lateinit var movieList:ArrayList<MovieDataClass>

    constructor(mContext: Context, movieList: ArrayList<MovieDataClass>) {
        this.mContext = mContext
        this.movieList = movieList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val v:View = LayoutInflater.from(mContext).inflate(R.layout.movie_info, parent, false)
        return MovieViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieName.text = movieList[position].getMovieName()
        holder.movieReleaseDate.text = movieList[position].getMovieReleaseDate()

        // Using Glide library to set imageView
        Glide.with(mContext)
            .load("https://image.tmdb.org/t/p/w500"+movieList[position].getMovieImage())
            .into(holder.imageView)
    }
}