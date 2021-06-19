package com.example.merchant.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.merchant.util.BaseViewModel
import com.example.merchant.util.Event
import javax.inject.Inject

class MenuViewModel @Inject constructor() : BaseViewModel() {

    private val _addNewItemClickEvent = MutableLiveData<Event<Unit>>()
    val addNewItemClickEvent: LiveData<Event<Unit>> = _addNewItemClickEvent

    fun addNewItemClick() {
        _addNewItemClickEvent.postValue(Event(Unit))
    }
}