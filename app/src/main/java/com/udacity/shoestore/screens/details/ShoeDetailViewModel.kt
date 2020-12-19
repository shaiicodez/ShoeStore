package com.udacity.shoestore.screens.details

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoeDetailViewModel : ViewModel() {


    val etName = MutableLiveData<String>() //edit text content

    val etSize = MutableLiveData<String>() //edit text content

    val etCompany = MutableLiveData<String>() //edit text content

    val etDesc = MutableLiveData<String>() //edit text content


    fun addShoes(view : View){
        // Retrieve values of text views
        var name = etName.value.toString()
        var size = etSize.value.toString().toDouble()
        var company = etCompany.value.toString()
        var desc = etDesc.value.toString()

        // Create an instance of shoe model
        val myShoes = Shoe(name,size,company,desc)

    }


}