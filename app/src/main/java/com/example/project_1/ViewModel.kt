package com.example.project_1

import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

class ViewModel: ViewModel() {
    var shoeList = arrayListOf<Shoe>()

    val listShoe = MutableLiveData<MutableList<Shoe>>();
    val currentList : LiveData<MutableList<Shoe>>
        get() = listShoe

    init {
        val list = arrayListOf<Shoe>()
        list.add( Shoe("Nike Air", "47.0","Nike", "Shoe for man"))
        listShoe.value = list
        Log.i("listShoe", listShoe.value.toString())

    }
}

@Parcelize
data class Shoe(var name: String? = "", var company: String? = "", var size: String? = "", var description: String? = "") :
    Parcelable
