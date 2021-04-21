package com.example.appfood.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.appfood.data.model.Recipe
import com.example.appfood.data.model.RecipeList
import com.example.appfood.databinding.ItemPlateBinding

/**
 * Created by Franco on 31/3/2021
 */
class PlateAdapter(private val list: RecipeList) : RecyclerView.Adapter<PlateAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemPlateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list.recipes[position])
    }

    override fun getItemCount() = list.recipes.size

    inner class ViewHolder(private val itemBinding: ItemPlateBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(plate: Recipe) {
            with(itemBinding) {
                tvPlate.text = plate.title
                ratingBar.rating = (plate.spoonacularScore / 20).toFloat()
            }

            Glide
                .with(itemView)
                .load(plate.image)
//                    .placeholder()
                .transform(CenterCrop(), RoundedCorners(25))
                .into(itemBinding.ivPLate)
        }
    }
}