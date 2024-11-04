package com.example.retrofit_datalistformvvm

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_datalistformvvm.apiservice.adapter.JokesAdapter
import com.example.retrofit_datalistformvvm.databinding.ActivityMainBinding
import com.example.retrofit_datalistformvvm.viewmodel.JokesViewmodel


class MainActivity : AppCompatActivity() {

    private val viewModel: JokesViewmodel by viewModels()
    private val jokesAdapter = JokesAdapter()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getRandamJokes()
        startRepeatingTimer()

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Set up RecyclerView
       binding. jokesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.jokesRecyclerView.adapter = jokesAdapter

        // Observe jokes data
        viewModel._jokesData.observe(this) { data ->

            binding.progressIndicator.visibility = View.GONE
            data?.let {
                jokesAdapter.updateJokes(it)
                Log.d("TAG", "Jokes: $it")
            } ?: Log.d("TAG", "Failed to fetch jokes or no data available")
        }



        startRepeatingTimer()

        binding.  fetchJokeButton.setOnClickListener {
              binding.progressIndicator.visibility = View.VISIBLE
          startRepeatingTimer()
        }







    }
    fun startRepeatingTimer() {
        object : CountDownTimer(2, 1) { // 10 seconds in milliseconds, ticking every 1 second

            override fun onTick(millisUntilFinished: Long) {
                // Update the UI to show countdown if desired
                // Example: binding.timerTextView.text = "Seconds remaining: ${millisUntilFinished / 1000}"

                startRepeatingTimer()
            }

            override fun onFinish() {
                // Fetch the joke after 10 seconds
                viewModel.getRandamJokes()
                binding.progressIndicator.visibility = View.GONE
                // Restart the timer
                startRepeatingTimer()
            }
        }.start()
    }

}