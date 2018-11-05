/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hucet.tyler.quick.media.db


import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hucet.tyler.quick.media.persistence.KakaoImage
import com.hucet.tyler.quick.media.persistence.KakaoVclip
import com.hucet.tyler.quick.media.persistence.MediumSearchResult
import com.hucet.tyler.quick.media.persistence.NaverImage
import java.util.concurrent.Executors


/**
 * Main database description.
 */
@Database(
        entities = [
            KakaoImage::class,
            KakaoVclip::class,
            NaverImage::class,
            MediumSearchResult::class
        ],
        version = 1,
        exportSchema = false
)
abstract class MediumDatabase : RoomDatabase() {

    abstract fun kakaoImageDao(): KakaoImageDao

    abstract fun kakaoVclipDao(): KakaoVclipDao

    abstract fun naverImageDao(): NaverImageDao

    abstract fun mediumSearchResultDao(): MediumSearchResultDao

    companion object {

        private var INSTANCE: MediumDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MediumDatabase {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context)
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        @Synchronized
        fun getInstanceInMemory(context: Context): MediumDatabase {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext, MediumDatabase::class.java)
                    .allowMainThreadQueries()
                    .populate(context)
                    .build()
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): MediumDatabase {
            return Room.databaseBuilder(context,
                    MediumDatabase::class.java, "medium_db")
                    .populate(context)
                    .build()
        }
    }
}

private fun <T : RoomDatabase> RoomDatabase.Builder<T>.populate(context: Context): RoomDatabase.Builder<T> {
    return this.addCallback(object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Executors.newSingleThreadScheduledExecutor().execute {
            }
        }
    })
}
