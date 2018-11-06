package com.hucet.tyler.quick.media.persistence

import android.graphics.pdf.PdfDocument
import androidx.room.TypeConverter
import androidx.room.TypeConverters
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

data class NextInfo(
        var kakaoImageNext: PageInfo = PageInfo(kakaoImage),
        var kakaoVClipNext: PageInfo = PageInfo(kakaoVClip),
        var naverImageNext: PageInfo = PageInfo(naverImage)
)

object DataSourceTypeConverter {
    @TypeConverter
    fun toDataSourceType(value: String): PageInfo.DataSourceType {
        return PageInfo.DataSourceType.valueOf(value)
    }

    @TypeConverter
    fun toStringName(dataSourceType: PageInfo.DataSourceType): String {
        return dataSourceType.name
    }
}