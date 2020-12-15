package com.udacity.shoestore.screens.onboarding

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {

    private lateinit var binding : FragmentOnboardingBinding
    private lateinit var username : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding, container, false)

        //get the username value entered in Name edit text in login screen
        val args = OnboardingFragmentArgs.fromBundle(requireArguments())
        username = args.usernameArg

        binding.apply {

            binding.usernameTxt.text = username
        }

        binding.instructionsBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_onboardingFragment_to_instructionsFragment))

        return binding.root
    }

}