package com.hucet.tyler.quick.media.testing.executor

import com.hucet.tyler.quick.media.android.testing.utils.AppExecutors
import java.util.concurrent.Executor

class InstantAppExecutors : AppExecutors(instant, instant, instant) {
    companion object {
        val instant = Executor { it.run() }
    }
}
