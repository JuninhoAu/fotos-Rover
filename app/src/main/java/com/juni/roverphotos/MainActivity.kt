package com.juni.roverphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.juni.roverphotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.roverRecycle.layoutManager=LinearLayoutManager(this)
        val divider= DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.roverRecycle.addItemDecoration(divider)

        val adapter=RoverAdapter()
        binding.roverRecycle.adapter=adapter


        val viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.roverList.observe(this, Observer {

            //Hi

            it->        adapter.submitList(it)

        })





    }
}