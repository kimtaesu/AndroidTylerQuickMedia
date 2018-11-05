package com.hucet.tyler.quick.media.persistence

import androidx.room.*
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.Companion.SEARCH_RESULT_TABLE
import java.util.*

@Entity(
        tableName = SEARCH_RESULT_TABLE,
        indices = [Index("query")]
)
data class MediumSearchResult(
        val query: String,
//val medium_ids = List<String>()
        val sortType: SearchSortType = SearchSortType.recency,
        val categoryType: Int = SearchCategoryOptionType.all.bit,
        @Embedded
        val nextInfo: NextInfo = NextInfo(),
        val updatedTime: Long = System.currentTimeMillis(),
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = SEARCH_RESULT_ID)
        var id: Long = 0
) {
    companion object {
        const val SEARCH_RESULT_ID = "search_result_id"
        const val SEARCH_RESULT_TABLE = "search_results"
    }

    enum class SearchCategoryOptionType(val bit: Int) {
        kakaoImage(1), kakaoVClip(2), naverImage(4), all(7)
    }

    enum class SearchSortType {
        accuracy, recency
    }
}


