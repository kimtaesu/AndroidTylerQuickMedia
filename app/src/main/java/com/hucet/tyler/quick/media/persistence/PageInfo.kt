package com.hucet.tyler.quick.media.persistence

import androidx.annotation.IntDef
import androidx.annotation.StringDef
import com.hucet.tyler.quick.media.persistence.PageInfo.DataSourceType.kakaoImage
import com.hucet.tyler.quick.media.persistence.PageInfo.DataSourceType.kakaoVClip
import com.hucet.tyler.quick.media.persistence.PageInfo.DataSourceType.naverImage

data class PageInfo(
        var next: Int = 1,
        var isEnd: Boolean = false
) {
    object DataSourceType {
        const val kakaoImage = "kakaoImage"
        const val kakaoVClip = "kakaoVClip"
        const val naverImage = "naverImage"

        @StringDef(kakaoImage, kakaoVClip, naverImage)
        @Retention(AnnotationRetention.SOURCE)
        annotation class DataSourceType
    }

    companion object {
        @JvmStatic
        fun initPageInfos(): Map<String, PageInfo> = mapOf(
                kakaoImage to PageInfo(),
                kakaoVClip to PageInfo(),
                naverImage to PageInfo()
        )
    }
}