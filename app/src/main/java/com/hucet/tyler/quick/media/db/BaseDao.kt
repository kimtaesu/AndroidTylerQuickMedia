package com.hucet.tyler.quick.media.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.hucet.tyler.quick.media.persistence.MediumSearchResult

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg items: T): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertIfNotExist(item: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(items: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(obj: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg obj: T)
}