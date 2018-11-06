package com.hucet.tyler.quick.media.view

import androidx.room.Embedded
import androidx.room.Relation
import com.hucet.tyler.quick.media.model.HasMedia
import com.hucet.tyler.quick.media.persistence.*

class MediumView {
    @Embedded
    var searchResult: MediumSearchResult? = null

    @Relation(
            parentColumn = MediumSearchResult.SEARCH_RESULT_ID,
            entityColumn = MediumSearchResult.SEARCH_RESULT_ID,
            entity = KakaoImage::class)
    var kakaoImage: List<KakaoImage>? = null

    @Relation(
            parentColumn = MediumSearchResult.SEARCH_RESULT_ID,
            entityColumn = MediumSearchResult.SEARCH_RESULT_ID,
            entity = KakaoImage::class)
    var kakaoVclip: List<KakaoVclip>? = null

    @Relation(
            parentColumn = MediumSearchResult.SEARCH_RESULT_ID,
            entityColumn = MediumSearchResult.SEARCH_RESULT_ID,
            entity = KakaoImage::class)
    var naverImage: List<NaverImage>? = null

}