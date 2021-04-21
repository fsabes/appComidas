package com.example.appfood.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfood.databinding.ItemCategoriesBinding

/**
 * Created by Franco on 31/3/2021
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemBinding =
            ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = categoriesSpanish.size

    inner class ViewHolder(private val itemBinding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
            fun onBind(){
                itemBinding.tvTitle.text = categoriesSpanish[adapterPosition]
            }
    }


    private val categoriesEnglish = arrayOf("main course", "side dish", "dessert", "appetizer",
                "salad", "bread", "breakfast", "soup", "beverage", "sauce",
                "marinade", "fingerfood", "snack", "drink")

    private val categoriesSpanish = arrayOf ("plato \n principal", "guarnición", "postre", "aperitivo",
        "ensalada", "pan", "desayuno", "sopa", "bebida", "salsa",
        "adobo", "bocadillo", "bocadillo", "bebida")
}