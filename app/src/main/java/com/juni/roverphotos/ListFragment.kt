package com.juni.roverphotos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.juni.roverphotos.databinding.FragmentListBinding
import java.lang.ClassCastException


class ListFragment : Fragment() {


    interface ItemSelectListener{

        fun onItemSelected(photos: Photos)

    }

    private lateinit var itemSelectListener: ItemSelectListener


    override fun onAttach(context: Context) {
        super.onAttach(context)
        itemSelectListener=try {
            context as ItemSelectListener

        }catch (e:ClassCastException){

            throw ClassCastException("$context debe implementar ItemSelectListerner")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view= FragmentListBinding.inflate(inflater)

        val recycler=view.listareci

        recycler.layoutManager=LinearLayoutManager(requireActivity())

        val divider= DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)

        recycler.addItemDecoration(divider)

        val roverAdapter=RoverAdapter()

        recycler.adapter=roverAdapter

        val viewModel=ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        roverAdapter.onItemClickListener={

            itemSelectListener.onItemSelected(it)
        }


        viewModel.roverList.observe(this, Observer {

            it->roverAdapter.submitList(it)


        })



        return view.root

    }


}