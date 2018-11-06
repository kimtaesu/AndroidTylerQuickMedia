package com.hucet.tyler.quick.media.repository

import com.hucet.tyler.quick.media.feed.MediumRemoteSource
import com.hucet.tyler.quick.media.persistence.MediumSearchResult
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchOptions
import javax.inject.Inject
import javax.inject.Singleton

interface MediumRepository {
    fun searchMedium(
            keyword: String,
            @SearchOptions.CategoryType category: Int,
            @SearchOptions.SortType sortOptions: Int) {
        @Singleton
        class MediumReposiotryImpl @Inject constructor(
                private val remote: MediumRemoteSource
        ) : MediumRepository {
            override fun searchMedium(
                    keyword: String,
                    @SearchOptions.CategoryType category: Int,
                    @SearchOptions.SortType sortOptions: Int) {
                remote.searchMedium()
            }
        }
    }
}