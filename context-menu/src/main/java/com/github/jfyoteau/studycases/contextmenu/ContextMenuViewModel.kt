package com.github.jfyoteau.studycases.contextmenu

import androidx.lifecycle.ViewModel

class ContextMenuViewModel : ViewModel() {

    private var action: ContextMenuAction? = null

    fun setAction(action: ContextMenuAction?) {
        this.action = action
    }

    fun clickButton() {
        action?.showContextMenu()
    }
}