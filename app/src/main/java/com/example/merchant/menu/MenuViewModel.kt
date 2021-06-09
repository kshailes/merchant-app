package com.example.merchant.menu

import androidx.lifecycle.MutableLiveData
import com.example.merchant.util.BaseViewModel
import com.example.merchant.util.Event
import javax.inject.Inject

class MenuViewModel @Inject constructor() : BaseViewModel() {

    val addNewItemClickEvent = MutableLiveData<Event<Unit>>()

    fun addNewItemClick() {
        addNewItemClickEvent.postValue(Event(Unit))
    }
}