package com.hucet.tyler.quick.media.api

data class KakaoRequest(
        val query: String,
        val sort: SortType,
        val page: Int,
        val size: Int
) {
    enum class SortType {
        accuracy, recency
    }
}