package com.github.jfyoteau.studycases.app

import android.app.Application
import com.github.jfyoteau.studycases.app.di.appModule
import com.github.jfyoteau.studycases.app.di.contextMenuModule
import com.github.jfyoteau.studycases.app.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class StudyCasesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupDependencyInjection()
    }

    private fun setupDependencyInjection() {
        startKoin {
            androidLogger()
            androidContext(this@StudyCasesApplication)
            modules(
                appModule,
                mainModule,
                contextMenuModule
            )
        }
    }
}
