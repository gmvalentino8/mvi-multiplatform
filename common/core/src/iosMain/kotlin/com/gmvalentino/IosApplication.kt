package com.gmvalentino

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual object MultiplatformApplication {

    fun initialize() {
        initApplication(
            module {
                val baseKermit = Kermit(NSLogLogger())
                factory { (tag: String?) -> if (tag != null) baseKermit.withTag(tag) else baseKermit }
            }
        )
    }
}