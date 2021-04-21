package com.example.appfood.data.remote

import com.example.appfood.data.model.Recipe
import com.example.appfood.data.model.RecipeList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by Franco on 31/3/2021
 */
object ApiClient {

    private const val API_BASE_URL = "https://api.spoonacular.com/"

    private var mInterface: AppService

    private var mRetrofitAdapter: Retrofit =
        Retrofit
            .Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .build()

    init {
        mInterface = mRetrofitAdapter.create(AppService::class.java)
    }

    fun getServiceClient() = mInterface

    interface AppService {

        @GET("recipes/random")
        suspend fun getRecipes(
            @Query("apiKey") apiKey: String,
            @Query("number") num: Int = 1
        ): RecipeList

//        @GET("recipes/{id}/similar")
//        suspend fun getRecipeSimilar(
//            @Path("id") id: Int,
//            @Query("apiKey") apiKey: String,
//            @Query("number") number: Int = 1
//        ): List<RecipeSimilar>
    }
}