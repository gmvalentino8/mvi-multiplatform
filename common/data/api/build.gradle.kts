buildTargets = setOf(BuildTarget.Android, BuildTarget.Ios)
projectDependencies = setOf(
    Module.Models,
    Module.Repository
)
setupMultiplatform()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Deps.SqlDelight.runtime)
                implementation(Deps.SqlDelight.coroutineExtensions)
                implementation(Deps.Ktor.clientCore)
                implementation(Deps.Ktor.clientJson)
                implementation(Deps.Ktor.clientLogging)
                implementation(Deps.Ktor.clientSerialization)
                implementation(Deps.Ktor.serialization)
                implementation(Deps.Kotlinx.coroutinesCore)
                implementation(Deps.Koin.core)
                implementation(Deps.Kotlinx.dateTime)
                api(Deps.Log.kermit)
            }
        }

        androidMain {
            dependencies {
                implementation(Deps.Ktor.clientAndroid)
                implementation(kotlin("stdlib", Versions.kotlin))
            }
        }

        iosMain {
            dependencies {
                implementation(Deps.Ktor.clientIos)
                implementation(Deps.Kotlinx.coroutinesCore) {
                    version {
                        strictly(Versions.kotlinCoroutines)
                    }
                }
            }
        }
    }
}
