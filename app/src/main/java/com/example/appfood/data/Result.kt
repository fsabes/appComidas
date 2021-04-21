package com.example.appfood.data

import java.lang.Exception

/**
 * Created by Franco on 12/4/2021
 */
sealed class Result<out T> {
    class Loading<out T> : Result<T>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}