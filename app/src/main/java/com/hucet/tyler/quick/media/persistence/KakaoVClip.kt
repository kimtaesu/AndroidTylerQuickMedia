package com.hucet.tyler.quick.media.persistence

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.hucet.tyler.quick.media.model.HasMedia
import com.hucet.tyler.quick.media.persistence.KakaoVclip.Companion.KAKAO_VCLIP_TABLE
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.Companion.SEARCH_RESULT_ID
import java.util.*

@Entity(
        tableName = KAKAO_VCLIP_TABLE,
        indices = [Index(SEARCH_RESULT_ID)],
        foreignKeys = [(ForeignKey(
                entity = MediumSearchResult::class,
                parentColumns = [(SEARCH_RESULT_ID)],
                childColumns = [(SEARCH_RESULT_ID)]
        ))]
)
data class KakaoVclip(val title: String,
                      @SerializedName("url")
                      override val origin: String,
                      override val thumbnail: String,
                      @SerializedName("play_time")
                      val playTime: Int,
                      val author: String,
                      @SerializedName("datetime")
                      val datetime: String,
                      @ColumnInfo(name = SEARCH_RESULT_ID)
                      val searchResultId: Long,
                      @PrimaryKey(autoGenerate = true)
                      @ColumnInfo(name = KAKAO_VCLIP_ID)
                      var id: Long = 0
) : HasMedia {
    companion object {
        const val KAKAO_VCLIP_TABLE = "kakao_vclips"
        const val KAKAO_VCLIP_ID = "kakao_vclip_id"
    }
}
