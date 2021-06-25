plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Versions1.androidCompileSdk)
    buildToolsVersion = Versions1.buildToolsVersion
    defaultConfig {
        applicationId = "com.gmvalentino"
        minSdkVersion(Versions1.androidMinSdk)
        targetSdkVersion(Versions1.androidTargetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            // proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
    implementation(project(":common:domain"))
    implementation(project(":common:presentation:features"))
    implementation(project(":common:presentation:core"))
    implementation(project(":common:core"))

    with(Deps.Kotlinx) {
        implementation(dateTime)
    }

    with(Deps.Android) {
        implementation(material)
        implementation(osmdroidAndroid)
    }

    with(Deps.AndroidX) {
        implementation(lifecycleRuntimeKtx)
        implementation(lifecycleViewmodelKtx)
        implementation(activityCompose)
    }

    with(Deps.Compose) {
        implementation(ui)
        implementation(uiGraphics)
        implementation(uiTooling)
        implementation(foundationLayout)
        implementation(material)
        implementation(navigation)
        implementation(accompanistCoil)
        implementation(accompanistPlaceholder)
    }

    with(Deps.Koin) {
        implementation(core)
        implementation(android)
        implementation(compose)
        testImplementation(test)
        testImplementation(testJUnit4)
    }

    with(Deps.Test) {
        testImplementation(junit)
        testImplementation(testCore)
        testImplementation(robolectric)
        testImplementation(mockito)
        androidTestImplementation(testRunner)
    }

    coreLibraryDesugaring(Deps1.desugarJdkLibs)
}
