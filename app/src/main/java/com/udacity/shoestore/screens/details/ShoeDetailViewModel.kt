package com.udacity.shoestore.screens.details

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel


class ShoeDetailViewModel : BaseObservable() {


    private lateinit var _name : String
    val name : String
        get() =_name

    private var _size : Double = 0.0
    val size : Double
        get() =_size

    private lateinit var _company : String
    val company : String
        get() = _company

    private lateinit var _desc : String
    val desc : String
        get() =_desc


    fun setName(n: String) {
        _name = n
    }

    fun setSize(s : Double) {
        _size = s
    }

    fun setCompany(c : String) {
        _company = c
    }

    fun setDesc(d:String) {
        _desc = d
    }

    @Bindable
    fun getNameTextWatcher(): TextWatcher? {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setName(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        }
    }

}