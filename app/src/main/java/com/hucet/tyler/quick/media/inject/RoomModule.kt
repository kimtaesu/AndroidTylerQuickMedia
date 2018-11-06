package com.hucet.tyler.quick.media.inject

import android.app.Application
import com.hucet.tyler.quick.media.db.MediumDatabase
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
}
