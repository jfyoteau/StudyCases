package com.github.jfyoteau.studycases

import org.gradle.api.Plugin
import org.gradle.api.Project

class HiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.forEach {
            println("$it")
        }
        target.afterEvaluate {
        }
        target.subprojects {
            afterEvaluate {
                when {
                    this.pluginManager.hasPlugin("com.android.application") -> {
                        setupAndroidProject(this)
                    }
                    this.pluginManager.hasPlugin("com.android.library") -> {
                        setupAndroidProject(this)
                    }
                }
            }
        }
    }

    private fun setupAndroidProject(project: Project) {
        println("setup project for hilt: ${project.name}")
        with(project.pluginManager) {
            if (!hasPlugin("kotlin-kapt")) {
                apply("kotlin-kapt")
            }
            if (!hasPlugin("dagger.hilt.android.plugin")) {
                apply("dagger.hilt.android.plugin")
            }
        }
        with(project.dependencies) {
            add("implementation", "com.google.dagger:hilt-android:${Versions.dagger}")
            add("kapt", "com.google.dagger:hilt-android-compiler:${Versions.dagger}")
        }
    }
}
