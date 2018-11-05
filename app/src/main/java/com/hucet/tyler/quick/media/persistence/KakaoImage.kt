package com.hucet.tyler.quick.media.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hucet.tyler.quick.media.model.HasMedia
import com.hucet.tyler.quick.media.persistence.KakaoImage.Companion.KAKAO_IMAGE_TABLE

@Entity(
        tableName = KAKAO_IMAGE_TABLE,
        foreignKeys = [(ForeignKey(
                entity = MediumSearchResult::class,
                parentColumns = [(MediumSearchResult.SEARCH_RESULT_ID)],
                childColumns = [(MediumSearchResult.SEARCH_RESULT_ID)]
        ))]
)
data class KakaoImage(
        @SerializedName("thumbnail_url")
        override val thumbnail: String,
        @SerializedName("image_url")
        override val origin: String,
        val collection: String,
        val image_url: String,
        val width: Int,
        val height: Int,
        @SerializedName("display_sitename")
        val displaySiteName: String,
        val doc_url: String,
        val datetime: String,
        @ColumnInfo(name = MediumSearchResult.SEARCH_RESULT_ID)
        val searchResultId: Long,
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = KAKAO_IMAGE_ID)
        var id: Int = 0
) : HasMedia {
    companion object {
        const val KAKAO_IMAGE_TABLE = "kakao_image_table"
        const val KAKAO_IMAGE_ID = "kakao_image_id"
    }
}
