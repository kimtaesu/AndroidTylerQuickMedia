package com.hucet.tyler.quick.media

import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchCategoryOptionType
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchCategoryOptionType.all
import com.hucet.tyler.quick.media.persistence.MediumSearchResult.SearchSortType

interface MediumRepository {
    fun searchMedium(keyword: String,
                     searchOptions: SearchCategoryOptionType = all,
                     sortOptions: SearchSortType = SearchSortType.recency)
}