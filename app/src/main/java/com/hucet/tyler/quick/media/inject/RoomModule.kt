package com.hucet.tyler.quick.media.inject

import android.app.Application
import dagger.Provides
import javax.inject.Singleton
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.hucet.tyler.memo.db.MemoDao
import com.hucet.tyler.memo.db.MemoDb
import dagger.Module


@Module
class RoomModule {
    @Singleton
    @Provides
    internal fun providesRoomDatabase(application: Application): MemoDb {
        return MemoDb.getInstance(application)
    }
}
