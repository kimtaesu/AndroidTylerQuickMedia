package com.hucet.tyler.quick.media.persistence

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.hucet.tyler.quick.media.model.HasMedia
import com.hucet.tyler.quick.media.persistence.NaverImage.Companion.NAVER_IMAGE_TABLE
import java.util.*

@Entity(
        tableName = NAVER_IMAGE_TABLE
)
data class NaverImage(
        @SerializedName("link")
        override val origin: String,
        val title: String,
        override val thumbnail: String,
        val sizeheight: String,
        val sizewidth: String,
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = NAVER_IMAGE_ID)
        var id: Long = 0
) : HasMedia {
    companion object {
        const val NAVER_IMAGE_TABLE = "naver_images"
        const val NAVER_IMAGE_ID = "naver_image_id"
    }
}