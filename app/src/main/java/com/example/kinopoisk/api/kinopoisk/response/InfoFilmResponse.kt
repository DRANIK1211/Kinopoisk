package com.example.kinopoisk.api.kinopoisk.response


import com.google.gson.annotations.SerializedName

data class InfoFilmResponse(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("countries")
    val countries: List<Country>,
    @SerializedName("coverUrl")
    val coverUrl: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("editorAnnotation")
    val editorAnnotation: String,
    @SerializedName("endYear")
    val endYear: Int,
    @SerializedName("filmLength")
    val filmLength: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("has3D")
    val has3D: Boolean,
    @SerializedName("hasImax")
    val hasImax: Boolean,
    @SerializedName("imdbId")
    val imdbId: String,
    @SerializedName("isTicketsAvailable")
    val isTicketsAvailable: Boolean,
    @SerializedName("kinopoiskHDId")
    val kinopoiskHDId: String,
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int,
    @SerializedName("lastSync")
    val lastSync: String,
    @SerializedName("logoUrl")
    val logoUrl: String,
    @SerializedName("nameEn")
    val nameEn: String,
    @SerializedName("nameOriginal")
    val nameOriginal: String,
    @SerializedName("nameRu")
    val nameRu: String,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerializedName("productionStatus")
    val productionStatus: String,
    @SerializedName("ratingAgeLimits")
    val ratingAgeLimits: String,
    @SerializedName("ratingAwait")
    val ratingAwait: Double,
    @SerializedName("ratingAwaitCount")
    val ratingAwaitCount: Int,
    @SerializedName("ratingFilmCritics")
    val ratingFilmCritics: Double,
    @SerializedName("ratingFilmCriticsVoteCount")
    val ratingFilmCriticsVoteCount: Int,
    @SerializedName("ratingGoodReview")
    val ratingGoodReview: Double,
    @SerializedName("ratingGoodReviewVoteCount")
    val ratingGoodReviewVoteCount: Int,
    @SerializedName("ratingImdb")
    val ratingImdb: Double,
    @SerializedName("ratingImdbVoteCount")
    val ratingImdbVoteCount: Int,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double,
    @SerializedName("ratingKinopoiskVoteCount")
    val ratingKinopoiskVoteCount: Int,
    @SerializedName("ratingMpaa")
    val ratingMpaa: String,
    @SerializedName("ratingRfCritics")
    val ratingRfCritics: Double,
    @SerializedName("ratingRfCriticsVoteCount")
    val ratingRfCriticsVoteCount: Int,
    @SerializedName("reviewsCount")
    val reviewsCount: Int,
    @SerializedName("serial")
    val serial: Boolean,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("shortFilm")
    val shortFilm: Boolean,
    @SerializedName("slogan")
    val slogan: String,
    @SerializedName("startYear")
    val startYear: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("webUrl")
    val webUrl: String,
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