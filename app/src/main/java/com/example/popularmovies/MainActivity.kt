package com.example.popularmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var mQueue:RequestQueue
    private lateinit var movieList:ArrayList<MovieDataClass>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieList = ArrayList()
        recyclerView = findViewById(R.id.recyclerView)
        mQueue = Volley.newRequestQueue(this)

        jsonParse()

        addDataToRecyclerView()
    }

    private fun jsonParse() {
        val url: String = "https://api.themoviedb.org/3/movie/popular?api_key=fe410d60e6a4f6b070d5b512fab7e226"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val jsonArray: JSONArray = response.getJSONArray("results")

                Log.d("########", "${jsonArray.length()}")
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)

                    val movieDataModel = MovieDataClass()
                    movieDataModel.setMovieId(jsonObject.getString("id"))
                    movieDataModel.setMovieName(jsonObject.getString("title"))
                    movieDataModel.setMovieImage(jsonObject.getString("poster_path"))
                    movieDataModel.setMovieReleaseDate(jsonObject.getString("release_date"))

                    movieList.add(movieDataModel)
                }
            },
            { error ->
                Log.d("##########", "$error")
            }
        )

        // Added jsonObjectRequest to queue
        mQueue.add(jsonObjectRequest)
    }

    private fun addDataToRecyclerView() {
        val adapter = MovieAdapter(this, movieList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}