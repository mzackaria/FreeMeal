package com.messai.freemeal.api

import com.messai.freemeal.Meal
import org.json.JSONObject

const val MAX_NB_INGREDIENTS = 20


suspend fun getRandomMeal() : Meal {
    try {

        val response: String = MealApi.retrofitService.getRandomMeal().await()
        val jsonObject = JSONObject(response)
        val meals = parseMealJsonResult(jsonObject)
        return if (meals.size == 0)  throw Exception("No random meal found in api call")
        else meals.get(0)

    } catch (e: Exception) {
        throw e
    }

}

private fun parseMealJsonResult(json: JSONObject): ArrayList<Meal> {
    val meals = ArrayList<Meal>()
    val array = json.getJSONArray("meals")
    for (i in 0 until array.length()) {
        val mealObject = array.getJSONObject(i)
        val ingredients: Map<String, String> = getMapIngredientsFromJson(mealObject)
        val tags: List<String> = mealObject.getString("strTags").split(",")
        val meal = Meal(
            mealObject.getLong("idMeal"),
            mealObject.getString("strMeal"),
            mealObject.getString("strDrinkAlternate"),
            mealObject.getString("strCategory"),
            mealObject.getString("strArea"),
            mealObject.getString("strInstructions"),
            mealObject.getString("strMealThumb"),
            tags,
            mealObject.getString("strYoutube"),
            ingredients = ingredients,
            mealObject.getString("strSource"),
            mealObject.getString("strImageSource"),
            mealObject.getString("strCreativeCommonsConfirmed"),
            mealObject.getString("strCreativeCommonsConfirmed")
        )
        meals.add(meal)
    }
    return meals
}

fun getMapIngredientsFromJson(mealObject: JSONObject): Map<String, String> {
    val map : MutableMap<String, String> = mutableMapOf()
    for (i in 1 until MAX_NB_INGREDIENTS + 1) {
        map.put(mealObject.getString("strIngredient$i"), mealObject.getString("strMeasure$i"))
    }
    return map
}
