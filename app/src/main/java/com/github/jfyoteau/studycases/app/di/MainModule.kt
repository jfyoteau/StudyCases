package com.github.jfyoteau.studycases.app.di

import com.github.jfyoteau.studycases.main.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainViewModel() }
}
