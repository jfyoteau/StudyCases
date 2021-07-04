// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${com.github.jfyoteau.studycases.Versions.androidGradlePlugin}")
//        classpath( "com.google.dagger:hilt-android-gradle-plugin:${com.github.jfyoteau.studycases.Versions.dagger}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

//apply<com.github.jfyoteau.studycases.HiltPlugin>()

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
