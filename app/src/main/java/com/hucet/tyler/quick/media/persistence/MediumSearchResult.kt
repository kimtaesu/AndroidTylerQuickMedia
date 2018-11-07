package com.hucet.tyler.quick.media.persistence

import androidx.annotation.IntDef
import androidx.room.*
import com.hucet.tyler.quick.media.api.KakaoRequest
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.Companion.SEARCH_RESULT_TABLE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


@Entity(
        tableName = SEARCH_RESULT_TABLE,
        indices = [Index("query", "sortType", unique = true)],
        primaryKeys = ["query", "sortType"]
)
@TypeConverters(PageInfosConverters::class)
data class MediumSearchResult(
        val query: String,
        var pageInfos: Map<String, PageInfo> = PageInfo.initPageInfos(),
        @SearchOptions.SortType var sortType: Int = SearchOptions.accuracy,
        @SearchOptions.CategoryType var categoryType: Int = SearchOptions.all,
        val updatedTime: Long = System.currentTimeMillis()
) {
    companion object {
        const val SEARCH_RESULT_ID = "search_result_id"
        const val SEARCH_RESULT_TABLE = "search_results"
    }

    object SearchOptions {
        const val accuracy = 0;
        const val recency = 1;

        @IntDef(accuracy, recency)
        @Retention(AnnotationRetention.SOURCE)
        annotation class SortType

        const val kakaoImage = 1
        const val kakaoVClip = 2
        const val naverImage = 4
        const val all = kakaoImage + kakaoVClip + naverImage
        const val kakao = kakaoImage + kakaoVClip
        const val naver = naverImage

        @IntDef(kakaoImage, kakaoVClip, naverImage)
        @Retention(AnnotationRetention.SOURCE)
        annotation class CategoryType
    }
}


class PageInfosConverters {
    private val gson = Gson()

    @TypeConverter
    fun stringToPageInfoList(data: String?): Map<String, PageInfo> {
        if (data == null) {
            return PageInfo.initPageInfos()
        }

        val listType = object : TypeToken<Map<String, PageInfo>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun pageInfoListToString(someObjects: Map<String, PageInfo>): String {
        return gson.toJson(someObjects)
    }
}