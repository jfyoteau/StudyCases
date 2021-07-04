package com.github.jfyoteau.studycases.app.di

import com.github.jfyoteau.studycases.contextmenu.ContextMenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val contextMenuModule = module {

    viewModel { ContextMenuViewModel() }

}
