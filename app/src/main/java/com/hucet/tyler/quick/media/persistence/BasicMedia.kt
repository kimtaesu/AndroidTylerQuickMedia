package com.hucet.tyler.quick.media.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hucet.tyler.quick.media.model.HasMedia

abstract class BasicMedia {
    abstract val thumbnail: String
    abstract val origin: String
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = MEDIA_ID)
    var id: Long = 0
    @ColumnInfo(name = MediumSearchResult.SEARCH_RESULT_ID)
    var searchResultId: Long = 0

    companion object {
        const val MEDIA_ID = "media_id"
    }
}