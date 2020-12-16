package com.udacity.shoestore

import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

class EditTextBindingAdapters {


    @BindingAdapter("textChangedListener")
    fun bindTextWatcher(editText: EditText, textWatcher: TextWatcher?) {
        editText.addTextChangedListener(textWatcher)
    }
}