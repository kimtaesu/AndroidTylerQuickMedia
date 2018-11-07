package com.hucet.tyler.quick.media.testing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hucet.tyler.quick.media.testing.rx.RxImmediateSchedulerRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations

abstract class SchedulerTest {
    @get:Rule
    var rxRule = RxImmediateSchedulerRule()
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun _setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun _tearDown() {
    }
}