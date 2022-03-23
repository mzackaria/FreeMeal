package com.messai.freemeal.random

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.messai.freemeal.Meal
import com.messai.freemeal.api.getRandomMeal
import kotlinx.coroutines.launch

class RandomViewModel(app: Application) : AndroidViewModel(app) {

    private val _meal = MutableLiveData<Meal>()
    val meal: LiveData<Meal>
        get() = _meal

    init {
        initMeal()
    }

    private fun initMeal() {
        viewModelScope.launch {
            try {
                _meal.value = getRandomMeal()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}