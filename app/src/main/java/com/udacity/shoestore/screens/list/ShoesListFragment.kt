package com.udacity.shoestore.screens.list

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.SharedViewModel


class ShoesListFragment : Fragment() {

    //call the view model
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        // Inflate the layout for this fragment
        val  binding : FragmentShoesListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoes_list,
            container,
            false)

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Navigate to Details Screen
        binding.fabAddShoes.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_shoeDetailFragment))

        //load data
        viewModel.shoesList.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach {

                // TODO (1): Linear View that contains data of one shoe
                val linearLayout = LinearLayout(context)
                // TODO (2): Linear View set up
                val linearParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                linearLayout.orientation = LinearLayout.VERTICAL
                linearParams.setMargins(0,0,0,15)
                linearLayout.layoutParams = linearParams
                linearLayout.setPadding(15,15,15,15)
                linearLayout.setBackgroundResource(R.color.white)

                // TODO (3): textviews for the shoe data
                val nameTextView = TextView(context)
                val name = it?.name
                nameTextView.text = "Name: $name"
                linearLayout.addView(nameTextView)

                val sizeTextView = TextView(context)
                val size = it?.size.toString()
                sizeTextView.text = "Size: $size"
                linearLayout.addView(sizeTextView)

                val companyTextView = TextView(context)
                val company = it?.company
                companyTextView.text = "Brand: $company"
                linearLayout.addView(companyTextView)

                val descTextView = TextView(context)
                val desc = it?.description
                descTextView.text = "Description: $desc"
                linearLayout.addView(descTextView)


                // TODO (4): give the root linearlayout a child of linear layout card of each shoe
                binding.rootContainer.addView(linearLayout)
            }
        })

        // Set up option menu to logout
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout ->
                Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}