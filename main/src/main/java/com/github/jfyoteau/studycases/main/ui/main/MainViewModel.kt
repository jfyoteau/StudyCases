package com.github.jfyoteau.studycases.main.ui.main

import androidx.annotation.StringRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.github.jfyoteau.studycases.main.R

class MainViewModel : ViewModel() {

    data class MenuValue(
        @StringRes val label: Int,
        val action: () -> Unit
    )

    private var action: MainAction? = null

    private val list = listOf(
        MenuValue(R.string.popup_window_list) {
            action?.navigateToPopupWindowList()
        }
    )

    private val listValue = MutableLiveData(list)

    fun setAction(action: MainAction?) {
        this.action = action
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<MenuValue>>) {
        listValue.observe(lifecycleOwner, observer)
    }

    fun clickMenu(menu: MenuValue) {
        menu.action.invoke()
    }
}
