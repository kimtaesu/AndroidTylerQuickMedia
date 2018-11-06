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
//        @TypeConverters(SortTypeConverter::class)
//        var sortType: SearchSortType = SearchSortType.recency,
//        @TypeConverters(SearchCategoryOptionType::class)
//        var categoryType: Int = SearchCategoryOptionType.all.bit,
//        @Embedded
//        @TypeConverters(DataSourceTypeConverter::class)
//        var nextInfo: NextInfo = NextInfo(),
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
        kakaoImage(1), kakaoVClip(2), naverImage(4), all(7);

        companion object {
            @JvmStatic
            fun categoryTypeFromBit(bit: Int): SearchCategoryOptionType {
                return SearchCategoryOptionType.values().find {
                    it.bit == bit
                } ?: SearchCategoryOptionType.all
            }
        }
    }

    enum class SearchSortType {
        accuracy, recency
    }
}

object SortTypeConverter {
    @TypeConverter
    fun toSortTypee(value: String): MediumSearchResult.SearchSortType {
        return MediumSearchResult.SearchSortType.valueOf(value)
    }

    @TypeConverter
    fun toStringName(sortType: MediumSearchResult.SearchSortType): String {
        return sortType.name
    }
}

object CategoryTypeConverter {
    @TypeConverter
    fun toCategoryTypee(value: Int): MediumSearchResult.SearchCategoryOptionType {
        return MediumSearchResult.SearchCategoryOptionType.categoryTypeFromBit(value)
    }

    @TypeConverter
    fun toStringName(sortType: MediumSearchResult.SearchCategoryOptionType): Int {
        return sortType.bit
    }
}
