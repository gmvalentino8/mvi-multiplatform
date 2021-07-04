buildTargets = setOf(BuildTarget.Ios)
setupMultiplatform()

plugins {
    kotlin("native.cocoapods")
}

kotlin {

    cocoapodsConfig {
        summary = "MVIMultiplatform"
        homepage = "https://github.com/gmvalentino/mvi-multiplatform"
        frameworkName = "MVIMultiplatform"
    }

    sourceSets {
        commonMain {
            dependencies {
                Module.values().forEach { api(project(it.path)) }
            }
        }

        iosMain { }
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations.forEach {
            it.kotlinOptions.freeCompilerArgs += arrayOf("-linker-options", "-lsqlite3")
        }
        binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework> {
            isStatic = true
            transitiveExport = true
            Module.values().forEach { export(project(it.path)) }
        }
    }
}
