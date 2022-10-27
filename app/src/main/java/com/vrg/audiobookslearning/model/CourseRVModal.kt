package com.vrg.audiobookslearning.model

data class Genres(
    val data: List<GenresItem>
)

data class GenresItem(
    var name: String?,
    var image: Int
)