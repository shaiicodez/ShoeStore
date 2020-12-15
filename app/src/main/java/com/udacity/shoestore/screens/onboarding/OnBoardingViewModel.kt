package com.udacity.shoestore.screens.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class OnBoardingViewModel : ViewModel(){

    // Local variable
    private val _username = MutableLiveData<String>()

    // Global variable for external access
    val username: LiveData<String>
        get() = _username

}