package com.hucet.tyler.quick.media.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hucet.tyler.quick.media.model.HasMedia
import com.hucet.tyler.quick.media.persistence.NaverImage.Companion.NAVER_IMAGE_TABLE

@Entity(
        tableName = NAVER_IMAGE_TABLE,
        foreignKeys = [(ForeignKey(
                entity = MediumSearchResult::class,
                parentColumns = [(MediumSearchResult.SEARCH_RESULT_ID)],
                childColumns = [(MediumSearchResult.SEARCH_RESULT_ID)]
        ))]
)
data class NaverImage(
        @SerializedName("link")
        override val origin: String,
        val title: String,
        override val thumbnail: String,
        val sizeheight: String,
        val sizewidth: String,
        @ColumnInfo(name = MediumSearchResult.SEARCH_RESULT_ID)
        val searchResultId: Long,
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = NAVER_IMAGE_ID)
        var id: Int = 0
) : HasMedia {
    companion object {
        const val NAVER_IMAGE_TABLE = "naver_images"
        const val NAVER_IMAGE_ID = "naver_image_id"
    }
}