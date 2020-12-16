package com.udacity.shoestore.screens.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set Fragment Theme
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        val contextThemeWrapper: Context = ContextThemeWrapper(activity, R.style.AppTheme)
        // clone the inflater using the ContextThemeWrapper
        val localInflater = inflater.cloneInContext(contextThemeWrapper)

        // Inflate the layout for this fragment
        binding = inflate(localInflater, R.layout.fragment_login, container, false)



        binding.signInBtn.setOnClickListener { view: View ->

            // Using SafeArgs to send username entered into the field, so Directions are use
            //if user enters name in name textfield, send it on boarding screen to display it
            Navigation.findNavController(view).navigate(
                LoginFragmentDirections.actionLoginFragmentToOnboardingFragment(    // Send username to other screens using bundle
                    binding.etUsername.text.toString()
                )
            )
        }

        binding.signUpBtn.setOnClickListener{ view: View ->

            // Using SafeArgs to send username entered into the field, so Directions are used
            view.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToOnboardingFragment(
                    binding.etUsername.text.toString()
                )
            )
        }

        return binding.root
    }

}