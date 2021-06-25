import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

buildTargets = setOf(BuildTarget.Android, BuildTarget.Ios)

plugins {
    id("com.squareup.sqldelight")
}

setupMultiplatform()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Deps1.SqlDelight.runtime)
                implementation(Deps1.SqlDelight.coroutinesExtensions)
                implementation(Deps.Koin.core)
                implementation(Deps1.Ktor.commonSerialization)
                implementation(Deps1.kotlinxDateTime)
                api(Deps1.kermit)
                implementation(project(":common:data:models"))
                implementation(project(":common:data:repository"))
            }
        }

        androidMain {
            dependencies {
                implementation(kotlin("stdlib", Versions1.kotlin))
                implementation(Deps1.SqlDelight.driverAndroid)
                implementation(Deps1.Coroutines.android)
            }
        }

        iosMain {
            dependencies {
                implementation(Deps1.SqlDelight.driverIos)
                implementation(Deps1.Coroutines.common) {
                    version {
                        strictly(Versions1.coroutines)
                    }
                }
            }
        }
    }

    // Configure the framework which is generated internally by cocoapods plugin
    targets.withType<KotlinNativeTarget> {
        binaries.withType<Framework> {
            isStatic = true
            export(Deps1.kermit)
            transitiveExport = true
        }
    }
}

sqldelight {
    database("Db") {
        packageName = "com.gmvalentino.db"
    }
}
