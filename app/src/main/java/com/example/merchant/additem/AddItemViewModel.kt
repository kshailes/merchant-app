package com.example.merchant.additem

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.merchant.entity.Item
import com.example.merchant.repository.ItemRepository
import com.example.merchant.util.BaseViewModel
import com.example.merchant.util.Event
import com.example.merchant.util.Network.Outcome
import com.example.merchant.util.Util
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddItemViewModel @Inject constructor(private val itemRepository: ItemRepository) :
    BaseViewModel() {

    val enteredName = ObservableField("")
    val enteredPrice = ObservableField("")
    private val _enteredPrice =
        if (enteredPrice.get().isNullOrEmpty()) 0.0 else enteredPrice.get()?.toDouble()
    val enteredUnit = ObservableField("")
    val enteredDescription = ObservableField("")

    val itemSavedEvent = MutableLiveData<Event<Boolean>>()

    fun save() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = itemRepository.addItem(Item().apply {
                    name = enteredName.get()!!
                    price = Util.doubleMoneyToLongMoney(_enteredPrice)
                    unit = enteredUnit.get()!!
                    description = enteredDescription.get()!!
                })
                when (response) {
                    is Outcome.Success -> {
                        itemRepository.saveItem(response.data)
                        itemSavedEvent.postValue(Event(false))
                    }
                    is Outcome.Error -> {
                        Log.d("Error", response.error.message)
                    }
                }

            }
        }
    }
}