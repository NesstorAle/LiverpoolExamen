package com.example.liverpoolexamen.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liverpoolexamen.common.utils.RequestState
import com.example.liverpoolexamen.dataSource.ItemDataSource
import com.example.liverpoolexamen.repository.ItemRepository
import com.example.liverpoolexamen.webservice.responses.ItemResponse

class MainViewModel(private val repository: ItemRepository): ViewModel() {

    lateinit var responseItem: MutableLiveData<ItemResponse>
    var itemDataSource: ItemDataSource = repository.requestItemsDataSource()
    var responseState: MutableLiveData<RequestState> = itemDataSource.responseState

    fun getItems(itemToFind: String){
        responseItem = itemDataSource.responseItem
        itemDataSource.requestItem(itemToFind)
    }
}