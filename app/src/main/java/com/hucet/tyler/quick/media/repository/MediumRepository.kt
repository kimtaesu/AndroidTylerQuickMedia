package com.hucet.tyler.quick.media.repository

import com.hucet.tyler.quick.media.feed.MediumRemoteSource
import com.hucet.tyler.quick.media.persistence.MediumSearchResult
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchCategoryOptionType
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchCategoryOptionType.all
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchSortType
import javax.inject.Inject
import javax.inject.Singleton

interface MediumRepository {
    fun searchMedium(keyword: String,
                     searchOptions: SearchCategoryOptionType = all,
                     sortOptions: SearchSortType = SearchSortType.recency) {
        @Singleton
        class MediumReposiotryImpl @Inject constructor(
                private val remote: MediumRemoteSource
        ) : MediumRepository {
            override fun searchMedium(keyword: String, searchOptions: MediumSearchResult.SearchCategoryOptionType, sortOptions: MediumSearchResult.SearchSortType) {
                remote.searchMedium()
            }
        }
    }
}