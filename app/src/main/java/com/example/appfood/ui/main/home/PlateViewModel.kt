package com.example.appfood.ui.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.appfood.data.Result
import com.example.appfood.data.repository.PlateRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by Franco on 12/4/2021
 */
class PlateViewModel(private val repository: PlateRepository) : ViewModel() {
    fun getPlate() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repository.getPLate()))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

//    fun getPlateSimilar(i: Int) = liveData(Dispatchers.IO) {
//        emit(Result.Loading())
//        try {
//            emit(Result.Success(repository.getPlateSimilar(i)))
//        } catch (e: Exception) {
//            emit(Result.Error(e))
//        }
//    }

    class PLateViewModelFactory(private val repository: PlateRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(PlateRepository::class.java).newInstance(repository)
        }
    }
}