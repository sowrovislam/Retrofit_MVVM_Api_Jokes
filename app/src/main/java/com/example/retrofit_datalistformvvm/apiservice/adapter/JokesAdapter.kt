package com.example.retrofit_datalistformvvm.apiservice.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_datalistformvvm.R
import com.example.retrofit_datalistformvvm.data.ResponseJoks


class JokesAdapter : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {

    private val jokesList = mutableListOf<ResponseJoks>()

    fun updateJokes(newJoke: ResponseJoks) {
        jokesList.add(newJoke)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return JokesViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(jokesList[position])
    }

    override fun getItemCount() = jokesList.size

    class JokesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val jokeText: TextView = itemView.findViewById(R.id.jokeText)

        fun bind(joke: ResponseJoks) {
            // Check if the `joke` field contains text
            if (!joke.joke.isNullOrEmpty()) {
                jokeText.text = joke.joke
            }
            // Otherwise, check if `delivery` field contains text
            else if (joke.delivery == true) {
                jokeText.text = joke.delivery.toString()
            } else {
                // Handle cases where neither `joke` nor `delivery` has content
                jokeText.text = "No joke available"
            }
        }}}
