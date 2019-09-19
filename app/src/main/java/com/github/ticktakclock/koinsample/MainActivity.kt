package com.github.ticktakclock.koinsample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.github.ticktakclock.koinsample.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "KoinSample"
    }

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this
        observeValue()
    }

    private fun observeValue() {
        val observer = Observer<String> {
            Log.d(TAG, it)
            try {
                viewModel.calculate(viewModel.a.value, viewModel.b.value)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }

        }
        viewModel.a.observe(this, observer)
        viewModel.b.observe(this, observer)
        viewModel.result.observe(this, Observer {
            Log.d(TAG, it)
        })
    }
}
