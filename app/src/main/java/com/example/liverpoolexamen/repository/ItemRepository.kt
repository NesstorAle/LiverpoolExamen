package com.example.liverpoolexamen.repository

import com.example.liverpoolexamen.dataSource.ItemDataSource
import com.example.liverpoolexamen.webservice.api.ItemApi

class ItemRepository(private val itemApi: ItemApi) {

    fun requestItemsDataSource(): ItemDataSource{
        return ItemDataSource(
            itemApi
        )
    }
}