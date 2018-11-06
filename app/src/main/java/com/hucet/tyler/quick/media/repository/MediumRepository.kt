package com.hucet.tyler.quick.media.repository

import com.hucet.tyler.quick.media.db.MediumSearchResultDao
import com.hucet.tyler.quick.media.feed.MediumRemoteSource
import com.hucet.tyler.quick.media.persistence.MediumSearchResult
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchOptions
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediumReposiotry @Inject constructor(
        private val remote: MediumRemoteSource,
        private val dao: MediumSearchResultDao
) {
    fun searchMedium(
            keyword: String,
            @SearchOptions.CategoryType category: Int,
            @SearchOptions.SortType sortType: Int) {

        dao.insertIfNotExist(MediumSearchResult(keyword, sortType = sortType))
        dao.search(keyword, sortType)



        remote.searchMedium(keyword)
    }
}