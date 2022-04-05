package com.example.liverpoolexamen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.request.RequestCoordinator
import com.example.liverpoolexamen.common.utils.RequestState
import com.example.liverpoolexamen.databinding.ActivityMainBinding
import com.example.liverpoolexamen.repository.ItemRepository
import com.example.liverpoolexamen.view.adapter.ItemAdapter
import com.example.liverpoolexamen.viewModel.MainViewModel
import com.example.liverpoolexamen.webservice.WebServiceClient

private lateinit var binding: ActivityMainBinding
private lateinit var viewModel: MainViewModel
private lateinit var itemList: MutableList<ItemToDisplay>
private lateinit var adapter: ItemAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = arrayListOf()
        adapter = ItemAdapter(itemList)
        viewModel = MainViewModel(
            ItemRepository(
                WebServiceClient().getItemsApi()
            )
        )

        binding.apply {
            rvItems.layoutManager = LinearLayoutManager(this@MainActivity)
            rvItems.adapter = adapter
            btnFind.setOnClickListener(this@MainActivity)
        }
    }

    fun initRecycler(itemList: MutableList<ItemToDisplay>) {
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.adapter = adapter
        adapter.setList(itemList)
    }

    override fun onClick(v: View?) {
        binding.apply {
            when(v?.id){
                btnFind.id -> {
                    viewModel.responseState.observe(this@MainActivity){
                        if(it.state == RequestState.REQ_IN_PROGRESS)
                            progressBar.visibility = View.VISIBLE
                        else
                            progressBar.visibility = View.GONE
                    }
                    viewModel.getItems(tietItem.text.toString())
                    viewModel.responseItem.observe( this@MainActivity){
                        itemList.clear()
                        it.plpResults.records.forEach { item ->
                            itemList.add(ItemToDisplay(image = item.smImage, price = item.listPrice.toString(), title = item.productDisplayName))
                            adapter.setList(itemList)
                        }
                    }
                }
            }
        }
    }
}