package com.example.liverpoolexamen.dataSource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.liverpoolexamen.common.utils.RequestState
import com.example.liverpoolexamen.webservice.api.ItemApi
import retrofit2.Callback
import com.example.liverpoolexamen.webservice.responses.ItemResponse
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class ItemDataSource (private val itemApi: ItemApi){
     var responseState = MutableLiveData<RequestState>()
     var responseItem = MutableLiveData<ItemResponse>()

     fun requestItem(itemToFind: String){
          responseState.value = RequestState(RequestState.REQ_IN_PROGRESS)

          itemApi.getItemsRequest(itemToFind, "1", "2").enqueue(object : Callback<ItemResponse> {
               override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                  when{
                       response.isSuccessful -> {
                            responseState.value = RequestState(RequestState.REQ_OK)
                            responseItem.postValue(response.body())
                       }
                       else -> {
                            responseState.value = RequestState(RequestState.REQ_BAD)
                            try{
                                 val jObjError = JSONObject(response.errorBody()!!.string())
                                 val gson = Gson()
                                 responseItem.postValue(
                                      gson.fromJson(
                                           jObjError.toString(),
                                           ItemResponse::class.java
                                      )
                                 )
                            }catch (e : Exception){
                                 responseItem.postValue(null)
                            }
                       }
                  }
               }

               override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                    responseState.value = RequestState(RequestState.REQ_BAD)
                    responseItem.postValue(null)
               }

          })
     }

}