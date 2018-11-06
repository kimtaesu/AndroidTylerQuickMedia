package com.hucet.tyler.quick.media.db

import androidx.room.Dao
import com.hucet.tyler.quick.media.OpenForTesting
import com.hucet.tyler.quick.media.persistence.KakaoImage

@Dao
@OpenForTesting
abstract class KakaoImageDao : BaseDao<KakaoImage> {

}