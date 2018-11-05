package com.hucet.tyler.quick.media.api

data class NaverRequest(
        val query: String,
        val display: Int,
        val start: Int, // max 1000
        val sort: SortType, // sim or date
        val filter: FilterType
) {
    enum class SortType {
        sim, date
    }

    enum class FilterType {
        all, large, medium, small
    }
}