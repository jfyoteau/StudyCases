import com.github.jfyoteau.studycases.BuildConfig
import com.github.jfyoteau.studycases.Versions

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = BuildConfig.compileSdk
    buildToolsVersion = BuildConfig.buildToolsVersion

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.github.jfyoteau.studycases.app"
        minSdk = BuildConfig.minSdk
        targetSdk = BuildConfig.targetSdk
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = BuildConfig.javaVersion
        targetCompatibility = BuildConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = BuildConfig.kotlinJvmTarget
    }
}

dependencies {
    implementation("androidx.core:core-ktx:${Versions.androidxCore}")
    implementation("androidx.appcompat:appcompat:${Versions.androidxAppCompat}")
    implementation("com.google.android.material:material:${Versions.androidMaterial}")
    implementation(project(mapOf("path" to ":main")))
    implementation(project(mapOf("path" to ":context-menu")))
    testImplementation("junit:junit:${Versions.junit}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.androidxTestJunit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.androidxTestEspresso}")

    // Koin
    implementation("io.insert-koin:koin-android:${Versions.koin}")
}
