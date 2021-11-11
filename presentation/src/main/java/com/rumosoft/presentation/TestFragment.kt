package com.rumosoft.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.rumosoft.presentation.databinding.TestFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private lateinit var viewModel: TestViewModel

    private var _binding: TestFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TestFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[TestViewModel::class.java]
        init()
    }

    private fun init() {
        doSomething()
        observeUiState()
    }

    private fun doSomething() {
        viewModel.doSomething()
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.testState.collect { state ->
                    when (state) {
                        is TestUiState.Loading -> processLoading()
                        is TestUiState.Success -> processSuccess()
                    }
                }
            }
        }
    }

    private fun processLoading() {
        binding.loading.visibility = View.VISIBLE
        binding.success.visibility = View.GONE
    }

    private fun processSuccess() {
        binding.loading.visibility = View.GONE
        binding.success.visibility = View.VISIBLE
    }
}