package com.hucet.tyler.quick.media.inject

import android.app.Application
import com.hucet.tyler.quick.media.db.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {
    @Singleton
    @Provides
    internal fun providesRoomDatabase(application: Application): MediumDatabase {
        return MediumDatabase.getInstance(application)
    }

    @Singleton
    @Provides
    internal fun providesMediumSearchResultDao(db: MediumDatabase): MediumSearchResultDao =
            db.mediumSearchResultDao()

    @Singleton
    @Provides
    internal fun providesKakaoImageDao(db: MediumDatabase): KakaoImageDao =
            db.kakaoImageDao()


    @Singleton
    @Provides
    internal fun providesKakaoVclipDao(db: MediumDatabase): KakaoVclipDao =
            db.kakaoVclipDao()

    @Singleton
    @Provides
    internal fun providesNaverImageDao(db: MediumDatabase): NaverImageDao =
            db.naverImageDao()
}
