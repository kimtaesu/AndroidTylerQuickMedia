package com.hucet.tyler.quick.media.debug

import timber.log.Timber

class OptionalTree(val threadName: Boolean = false) : Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
        var msg = message
        if (threadName)
            msg = "[${Thread.currentThread().name}] $message"
        super.log(priority, tag, msg, t)
    }
}