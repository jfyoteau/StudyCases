package com.github.jfyoteau.studycases.contextmenu

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.jfyoteau.studycases.contextmenu.databinding.ContextMenuFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContextMenuFragment : Fragment(), ContextMenuAction {

    companion object {
        fun newInstance() = ContextMenuFragment()
    }

    private val viewModel: ContextMenuViewModel by viewModel()
    private lateinit var binding: ContextMenuFragmentBinding
    private lateinit var listPopupWindow: ListPopupWindow
    private var selectedIndex = 0
    private val menu = mutableListOf(
        SelectableMenu(isSelected = true, title = "Choice 1")
        {

        },
        SelectableMenu(isSelected = false, title = "Choice 2")
        {

        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ContextMenuFragmentBinding.inflate(inflater, container, false).also {
            this.binding = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listPopupWindow = ListPopupWindow(requireContext()).apply {
            setAdapter(ContextMenuAdapter(requireContext(), menu))
            val width = resources.getDimension(R.dimen.context_menu_width)
            setWidth(width.toInt())
            val headerView = TextView(requireContext())
            headerView.setText(R.string.context_menu_title)
            headerView.gravity = Gravity.CENTER
            headerView.setBackgroundResource(R.drawable.header_background)
            setPromptView(headerView)
            isModal = true
            promptPosition = ListPopupWindow.POSITION_PROMPT_ABOVE
            animationStyle = 0
            setOnItemClickListener { _, _, position, _ ->
                selectMenu(position)
            }
            anchorView = binding.button
        }

        viewModel.setAction(this)
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.setAction(null)
    }

    private fun selectMenu(position: Int) {
        menu.forEachIndexed { index, selectableMenu ->
            val isSelected = index == position
            menu[index] = selectableMenu.copy(isSelected = isSelected)
        }

        selectedIndex = position
        listPopupWindow.dismiss()

        menu[position].action.invoke()
    }

    override fun showContextMenu() {
        listPopupWindow.show()
    }
}
