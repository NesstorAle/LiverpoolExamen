package com.example.liverpoolexamen.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liverpoolexamen.R
import com.example.liverpoolexamen.databinding.ItemLiverpoolBinding
import com.example.liverpoolexamen.view.ItemToDisplay

class ItemAdapter(var itemsToDisplay: List<ItemToDisplay>): RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_liverpool, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.render(itemsToDisplay[position])
    }

    override fun getItemCount(): Int {
        return itemsToDisplay.size
    }

    inner class ItemHolder(private val view: View):RecyclerView.ViewHolder(view){
        val binding = ItemLiverpoolBinding.bind(view)

        fun render(item: ItemToDisplay){
          binding.apply {
              itemPrice.text = item.price
              itemTitle.text = item.title
              Glide.with(view.context)
                  .load(item.image)
                  .into(itemImage)
          }
        }
    }

    fun setList(items: MutableList<ItemToDisplay>){
        this.itemsToDisplay = items
        notifyDataSetChanged()
    }
}