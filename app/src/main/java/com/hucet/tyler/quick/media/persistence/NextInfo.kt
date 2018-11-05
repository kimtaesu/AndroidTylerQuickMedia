package com.hucet.tyler.quick.media.persistence

import android.graphics.pdf.PdfDocument
import com.hucet.tyler.quick.media.persistence.PageInfo.DataSourceType.*

data class PageInfo(
        val dataSourceType: DataSourceType,
        val next: Int = 1,
        val isEnd: Boolean = false
) {
    enum class DataSourceType {
        naverImage, kakaoImage, kakaoVClip
    }
}

class NextInfo(
        val kakaoImageNext: PageInfo = PageInfo(kakaoImage),
        val kakaoVClipNext: PageInfo = PageInfo(kakaoVClip),
        val naverImageNext: PageInfo  = PageInfo(naverImage)
)
