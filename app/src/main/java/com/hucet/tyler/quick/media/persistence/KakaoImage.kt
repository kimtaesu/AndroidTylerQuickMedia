package com.hucet.tyler.quick.media.persistence

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.hucet.tyler.quick.media.model.HasMedia
import com.hucet.tyler.quick.media.persistence.KakaoImage.Companion.KAKAO_IMAGE_TABLE

@Entity(
        tableName = KAKAO_IMAGE_TABLE
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
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = KAKAO_IMAGE_ID)
        var id: Long = 0
) : HasMedia {
    companion object {
        const val KAKAO_IMAGE_TABLE = "kakao_image_table"
        const val KAKAO_IMAGE_ID = "kakao_image_id"
    }
}
