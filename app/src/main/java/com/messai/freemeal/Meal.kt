package com.messai.freemeal

data class Meal (
    val  id: Long,
    val title: String,
    val drinkAlternance: String?,
    val category: String,
    val area: String,
    val instructions: String,
    val imageSrc: String,
    val tags: List<String>,
    val youtubeLink: String,
    val ingredients: Map<String, String>,
    val source: String,
    val secondaryImageSrc: String,
    val creativeCommonsConfirmed: String,
    val dateModified: String
)