package com.udacity.shoestore.screens.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoesListViewModel : ViewModel() {



    // A Shoe
    private val _shoe = MutableLiveData<Shoe>()

    val shoe: LiveData<Shoe>
        get() = _shoe


    // The initialization block
    init {
        Timber.i("ShoesListViewModel is created!")

    }


    // Callback called before view model is destroyed
    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoesListViewModel is destroyed")
    }

}