package com.juni.roverphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.juni.roverphotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ListFragment.ItemSelectListener {

    lateinit var photosFragment: PhotosFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        photosFragment=supportFragmentManager.findFragmentById(R.id.rover_photos) as PhotosFragment
       // binding.roverRecycle.layoutManager=LinearLayoutManager(this)



        val viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.roverList.observe(this, Observer {




        })





    }

    override fun onItemSelected(photos: Photos) {

        photosFragment.setPhotos(photos)

    }
}