package com.juni.roverphotos

import android.content.res.Resources
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class RoverAdapter:ListAdapter<Photos,RoverAdapter.RoverViewHolder>(DiffCallback) {

    companion object DiffCallback:DiffUtil.ItemCallback<Photos>(){

        override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {

            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {

            return oldItem==newItem
        }


    }

    lateinit var onItemClickListener:(Photos)->Unit



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoverAdapter.RoverViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.rover_list_items,parent,false)
        return RoverViewHolder(view)

    }

    override fun onBindViewHolder(holder: RoverAdapter.RoverViewHolder, position: Int) {

        val photos=getItem(position)
        holder.bind(photos)



    }


    inner class RoverViewHolder( private val view:View):RecyclerView.ViewHolder(view){

        private val txtId =view.findViewById<TextView>(R.id.txtexto)
        private val txtDate=view.findViewById<TextView>(R.id.tierra_date)
        private val txtcamera=view.findViewById<TextView>(R.id.camera_name)

        fun bind(photos: Photos){

            txtId.text= photos.id
            txtDate.text=photos.earth_date
            txtcamera.text=photos.camera_name

            view.setOnClickListener {

                if (::onItemClickListener.isInitialized){

                    //ejecutar al hacer click
                    onItemClickListener(photos)


                }
            }


        }









    }


}