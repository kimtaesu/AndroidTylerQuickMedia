package com.hucet.tyler.quick.media.persistence

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.hucet.tyler.quick.media.model.HasMedia
import com.hucet.tyler.quick.media.persistence.NaverImage.Companion.NAVER_IMAGE_TABLE
import java.util.*

@Entity(
        tableName = NAVER_IMAGE_TABLE,
        indices = [Index(MediumSearchResult.SEARCH_RESULT_ID)],
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
        val sizewidth: String
) : BasicMedia() {
    companion object {
        const val NAVER_IMAGE_TABLE = "naver_images"
        const val NAVER_IMAGE_ID = "naver_image_id"
    }
}