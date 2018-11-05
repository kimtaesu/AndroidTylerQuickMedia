package com.hucet.tyler.quick.media.model

import com.hucet.tyler.quick.media.persistence.NaverImage

data class NaverImageResponse(
        val display: Int,
        val start: Int,
        val total: Int,
        val lastBuildDate: String,
        val items: List<NaverImage>
)