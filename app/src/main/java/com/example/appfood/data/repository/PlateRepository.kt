package com.example.appfood.data.repository

import com.example.appfood.data.model.RecipeList
import com.example.appfood.data.remote.PlateDataSource

/**
 * Created by Franco on 12/4/2021
 */
class PlateRepository(private val dataSource : PlateDataSource) {
    suspend fun getPLate() : RecipeList{
        return dataSource.getRecipe()
    }
}