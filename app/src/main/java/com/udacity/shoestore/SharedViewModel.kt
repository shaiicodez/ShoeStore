package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    // The list of shoes
    // local access data
    private val _shoesList = MutableLiveData<MutableList<Shoe?>>()

    // The list of shoes, public access
    val shoesList: LiveData<MutableList<Shoe?>>
        get() = _shoesList

    init {
        // Initialization of list shoes
        _shoesList.value = mutableListOf(
            Shoe(name ="Sketchers Sneakers",
                size = 5.5,
                company = "Sketchers",
                description = "Leather in brown color",
                images = listOf("1", "2", "4")),
            Shoe(name ="Sketchers Slippers",
                size = 7.0,
                company = "Sketchers",
                description = "Perfect wear for a beach picnic",
                images = listOf("1", "2", "4")),
            Shoe(name ="Sketchers Running Shoes",
                size = 6.5,
                company = "Sketchers",
                description = "Running shoes",
                images = listOf("1", "2", "4")),
            Shoe(name ="Sketchers Sandals",
                size = 6.0,
                company = "Sketchers",
                description = "4cm Platform",
                images = listOf("1", "2", "4"))
        )
    }

    // Use this to add new shoes item
    fun addShoes(item: Shoe?) {
        item?.let {
            shoesList.value?.add(it)
        }
    }
}


