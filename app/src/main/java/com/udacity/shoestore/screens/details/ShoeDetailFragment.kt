package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var detailsViewModel: ShoeDetailViewModel
    //val editTextBinding : EditTextBindingAdapters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        // Cancel button
        binding.cancelBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoesListFragment))

        //reference to view model
        detailsViewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)

        binding.apply {
            this.setLifecycleOwner(this@ShoeDetailFragment)
            this.detailViewModel = detailsViewModel
        }

        // Add new shoes
        binding.addBtn.setOnClickListener { view : View ->

            // Retrieve values of text views thro view model
            val name = detailsViewModel.etName.value.toString()
            val size = detailsViewModel.etSize.value.toString().toDouble()
            val company = detailsViewModel.etCompany.value.toString()
            val desc = detailsViewModel.etDesc.value.toString()
            // Create an instance of shoe model
            val myShoes = Shoe(name,size,company,desc)
            // Add the new shoes to our life data using add method
            viewModel.addShoes(myShoes)
            //go to list screen
            view.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoesListFragment))
        }

        return binding.root
    }



}

