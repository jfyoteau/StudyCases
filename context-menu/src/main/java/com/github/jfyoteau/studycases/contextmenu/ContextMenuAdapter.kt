package com.github.jfyoteau.studycases.contextmenu

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView

class ContextMenuAdapter(
    context: Context,
    list: List<SelectableMenu>
) : ArrayAdapter<SelectableMenu>(context, R.layout.context_menu_item, R.id.label, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        with(view) {
            val checkBox = findViewById<ImageView>(R.id.imageView)
            val item = getItem(position) ?: return@with
            if (item.isSelected) {
                checkBox.visibility = View.VISIBLE
            } else {
                checkBox.visibility = View.INVISIBLE
            }
        }
        return view
    }
}
