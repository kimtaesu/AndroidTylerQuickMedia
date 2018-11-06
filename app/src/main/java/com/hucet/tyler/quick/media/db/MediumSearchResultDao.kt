package com.hucet.tyler.quick.media.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hucet.tyler.quick.media.OpenForTesting
import com.hucet.tyler.quick.media.persistence.MediumSearchResult
import com.hucet.tyler.quick.media.view.MediumView
import io.reactivex.Single

@Dao
@OpenForTesting
abstract class MediumSearchResultDao : BaseDao<MediumSearchResult> {
    @Query("select * from search_results where `query` = :keyword and sortType = :sortType")
    abstract fun search(keyword: String, sortType: Int): Single<MediumSearchResult>

    @Query("select * from search_results where `query` = :keyword and sortType = :sortType")
    abstract fun liveMedium(keyword: String, sortType: Int): LiveData<List<MediumView>>
}