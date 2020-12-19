package com.udacity.shoestore.screens.details

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Event
import com.udacity.shoestore.models.Shoe


class ShoeDetailViewModel : ViewModel() {

    //navigate live data
    private val _navigateToList = MutableLiveData<Boolean>()
    val navigateToList : LiveData<Boolean>
        get() = _navigateToList

    // local access data
    private val _shoesList = MutableLiveData<Shoe?>()

    // The list of shoes, public access
    val shoesList: LiveData<Shoe?>
        get() = _shoesList


    val etName = MutableLiveData<String>() //edit text content
    private val _name = MutableLiveData<String>()
    val name : LiveData<String>
        get() = _name


    val etSize = MutableLiveData<String>() //edit text content
    private val _size = MutableLiveData<Double>()
    val size : LiveData<Double>
            get() = _size


    val etCompany = MutableLiveData<String>() //edit text content
    private val _company = MutableLiveData<String>()
    val company : LiveData<String>
        get() = _company


    val etDesc = MutableLiveData<String>() //edit text content
    private val _desc = MutableLiveData<String>()
    val desc : LiveData<String>
        get() = _desc


    fun userClickAdd(){
        _navigateToList.value = true
    }

    fun addShoes() {

        // Retrieve values of text views
        _name.value = etName.value.toString()
        _size.value = etSize.value.toString().toDouble()
        _company.value = etCompany.value.toString()
        _desc.value = etDesc.value.toString()

        // Create an instance of shoe model
        val shoe: Shoe = Shoe(name = etName.value.toString(),
            size= etSize.value.toString().toDouble(),
            company = etCompany.value.toString(),
            description = etDesc.value.toString())

        _shoesList.value = shoe

        //_navigateToList.value = Event(itemId)
    }


}