package com.example.popularmovies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var movieName:TextView
    var imageView: ImageView
    var movieReleaseDate:TextView

    init {
        movieName = itemView.findViewById(R.id.movieName)
        movieReleaseDate = itemView.findViewById(R.id.movieReleaseDate)
        imageView  = itemView.findViewById(R.id.imageView)
    }

}