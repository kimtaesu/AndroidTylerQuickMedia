package com.hucet.tyler.quick.media.persistence

import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.hucet.tyler.quick.media.db.MediumDatabase
import com.hucet.tyler.quick.media.db.MediumSearchResultDao
import com.hucet.tyler.quick.media.testing.SchedulerTest
import com.hucet.tyler.quick.media.testing.TestApplication
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.shouldBe
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21], application = TestApplication::class)
class MediumSearchResultTest : SchedulerTest() {

    private lateinit var db: MediumDatabase

    private lateinit var mediumSearchResultDao: MediumSearchResultDao

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        db = MediumDatabase.getInstanceInMemory(ApplicationProvider.getApplicationContext())
        mediumSearchResultDao = db.mediumSearchResultDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun `MediumSearchResultDao primarykey unique (query sortType) `() {
        val recency = MediumSearchResult("test", sortType = MediumSearchResult.SearchOptions.recency)
        val accuracy = MediumSearchResult("test", sortType = MediumSearchResult.SearchOptions.accuracy)
        mediumSearchResultDao.insert(recency)
        mediumSearchResultDao.insert(recency)
        mediumSearchResultDao.insert(accuracy)
        mediumSearchResultDao.insert(accuracy)

        val observer = mock<Observer<List<MediumSearchResult>>>()
        mediumSearchResultDao.searchMediumByQuery("test").observeForever(observer)
        val captor = argumentCaptor<List<MediumSearchResult>>()
        verify(observer, times(1)).onChanged(captor.capture())

        captor.lastValue.size shouldBe 2
        captor.lastValue.shouldContain(recency)
        captor.lastValue.shouldContain(accuracy)
    }
}