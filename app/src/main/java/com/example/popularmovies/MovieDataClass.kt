package com.example.popularmovies

class MovieDataClass {

    private var movieName:String = ""
    private var movieImage:String = ""
    private var movieId:String = ""
    private var movieReleaseDate:String = ""

    constructor(movieName: String, movieImage: String, movieId: String) {
        this.movieName = movieName
        this.movieImage = movieImage
        this.movieId = movieId
    }

    constructor() {

    }

    fun setMovieName(movieName: String) {
        this.movieName = movieName
    }

    fun setMovieImage(movieImage: String) {
        this.movieImage = movieImage
    }

    fun setMovieId(movieId: String) {
        this.movieId = movieId
    }

    fun setMovieReleaseDate(movieReleaseDate: String) {
        this.movieReleaseDate = movieReleaseDate
    }

    fun getMovieName(): String {
        return movieName
    }

    fun getMovieImage(): String {
        return movieImage
    }

    fun getMovieId(): String {
        return movieId
    }

    fun getMovieReleaseDate(): String {
        return movieReleaseDate
    }

}