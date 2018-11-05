package com.hucet.tyler.quick.media.model

import com.hucet.tyler.quick.media.persistence.KakaoImage

data class KakaoImageResponse(
        val meta: Meta,
        val documents: List<KakaoImage>
)

