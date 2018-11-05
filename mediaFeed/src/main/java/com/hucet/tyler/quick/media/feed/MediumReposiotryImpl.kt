package com.hucet.tyler.quick.media.feed

import com.hucet.tyler.quick.media.MediumRepository
import com.hucet.tyler.quick.media.persistence.MediumSearchResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediumReposiotryImpl @Inject constructor(
        private val remote: MediumRemoteSource
) : MediumRepository {
    override fun searchMedium(keyword: String, searchOptions: MediumSearchResult.SearchCategoryOptionType, sortOptions: MediumSearchResult.SearchSortType) {
        remote.searchMedium()
    }
}