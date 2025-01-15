package com.example.kinopoisk.api.kinopoisk


import com.google.gson.annotations.SerializedName

data class PremierResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total")
    val total: Int
) {
    data class Item(
        @SerializedName("countries")
        val countries: List<Country>,
        @SerializedName("duration")
        val duration: Int,
        @SerializedName("genres")
        val genres: List<Genre>,
        @SerializedName("kinopoiskId")
        val kinopoiskId: Int,
        @SerializedName("nameEn")
        val nameEn: String,
        @SerializedName("nameRu")
        val nameRu: String,
        @SerializedName("posterUrl")
        val posterUrl: String,
        @SerializedName("posterUrlPreview")
        val posterUrlPreview: String,
        @SerializedName("premiereRu")
        val premiereRu: String,
        @SerializedName("year")
        val year: Int
    ) {
        data class Country(
            @SerializedName("country")
            val country: String
        )

        data class Genre(
            @SerializedName("genre")
            val genre: String
        )
    }
}