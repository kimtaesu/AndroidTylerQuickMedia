package com.hucet.tyler.quick.media.db

import androidx.room.Dao
import com.hucet.tyler.quick.media.OpenForTesting
import com.hucet.tyler.quick.media.persistence.MediumSearchResult

@Dao
@OpenForTesting
abstract class MediumSearchResultDao : BaseDao<MediumSearchResult> {

}