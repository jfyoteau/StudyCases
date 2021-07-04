package com.github.jfyoteau.studycases.contextmenu

data class SelectableMenu(
    val isSelected: Boolean,
    val title: String,
    val action: () -> Unit
) {
    override fun toString(): String {
        return title
    }
}
