package com.hucet.tyler.memo.util.executor

import com.hucet.tyler.quick.media.utils.AppExecutors
import java.util.concurrent.Executor

class InstantAppExecutors : AppExecutors(instant, instant, instant) {
    companion object {
        val instant = Executor { it.run() }
    }
}
