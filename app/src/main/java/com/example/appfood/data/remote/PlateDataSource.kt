package com.example.appfood.data.remote

import com.example.appfood.data.model.Recipe
import com.example.appfood.data.model.RecipeList
import com.example.appfood.util.Const

/**
 * Created by Franco on 12/4/2021
 */
class PlateDataSource {
    suspend fun getRecipe() : RecipeList = ApiClient.getServiceClient().getRecipes(Const.API_KEY,30)
//    suspend fun getPlateSimilar(i: Int): List<RecipeSimilar> = ApiClient.getServiceClient().getRecipeSimilar(i,Const.API_KEY,20)
}