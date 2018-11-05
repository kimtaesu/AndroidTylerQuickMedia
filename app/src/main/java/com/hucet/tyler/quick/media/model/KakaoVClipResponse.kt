package com.hucet.tyler.quick.media.model

import com.hucet.tyler.quick.media.persistence.KakaoImage
import com.hucet.tyler.quick.media.persistence.KakaoVclip


data class KakaoVClipResponse(
        val meta: Meta,
        val documents: List<KakaoVclip>
)
