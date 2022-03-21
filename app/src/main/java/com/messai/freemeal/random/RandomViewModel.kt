package com.messai.freemeal.random

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.messai.freemeal.Meal
import com.messai.freemeal.api.getRandomMeal
import kotlinx.coroutines.launch

class RandomViewModel(app: Application) : AndroidViewModel(app) {
    // TODO: Implement the ViewModelx`

    private val _meal = MutableLiveData<Meal>()
    val meal: LiveData<Meal>
        get() = _meal

    init {
        initMeal()
    }

    private fun initMeal() {
        viewModelScope.launch {
            try {
                val meal = getRandomMeal()
                _meal.value = meal
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}