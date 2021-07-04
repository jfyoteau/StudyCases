package com.github.jfyoteau.studycases.main.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.jfyoteau.studycases.contextmenu.ContextMenuFragment
import com.github.jfyoteau.studycases.main.R
import com.github.jfyoteau.studycases.main.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), MainAction {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater, container, false).also {
            this.binding = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()

        with(binding) {
            with(recyclerView) {
                layoutManager = LinearLayoutManager(this@MainFragment.requireContext())
                adapter = MainAdapter(viewModel).also {
                    this@MainFragment.adapter = it
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.setAction(null)
    }

    override fun navigateToPopupWindowList() {
        val fragment = ContextMenuFragment.newInstance()
        parentFragmentManager.beginTransaction().run {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun setupViewModel() {
        with(viewModel) {
            setAction(this@MainFragment)

            observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        }
    }
}
