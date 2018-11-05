package com.hucet.tyler.quick.media.db

import androidx.room.Dao
import com.hucet.tyler.memo.OpenForTesting
import com.hucet.tyler.quick.media.persistence.KakaoImage
import com.hucet.tyler.quick.media.persistence.KakaoVclip
import com.hucet.tyler.quick.media.persistence.NaverImage

@Dao
@OpenForTesting
abstract class NaverImageDao : BaseDao<NaverImage> {

}