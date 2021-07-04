import com.github.jfyoteau.studycases.BuildConfig
import com.github.jfyoteau.studycases.Versions

plugins {
    id("com.android.library")
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
        minSdk = BuildConfig.minSdk
        targetSdk = BuildConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}")

    testImplementation("junit:junit:${Versions.junit}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.androidxTestJunit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.androidxTestEspresso}")

    // Koin
    implementation("io.insert-koin:koin-android:${Versions.koin}")
}
