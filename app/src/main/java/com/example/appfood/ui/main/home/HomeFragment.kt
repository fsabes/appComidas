package com.example.appfood.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.appfood.R
import com.example.appfood.data.Result
import com.example.appfood.data.model.RecipeList
import com.example.appfood.data.remote.PlateDataSource
import com.example.appfood.data.repository.PlateRepository
import com.example.appfood.databinding.FragmentHomeBinding
import com.example.appfood.ui.base.BaseFragment
import com.example.appfood.ui.main.home.adapter.CategoryAdapter
import com.example.appfood.ui.main.home.adapter.PlateAdapter

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PlateViewModel>{ PlateViewModel.PLateViewModelFactory(
        PlateRepository(PlateDataSource())
    )}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        setAdapterCategory()

        viewModel.getPlate().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Loading -> {
                    binding.shimmerRecyclerView.showShimmerAdapter()
                }
                is Result.Success -> {
                    binding.shimmerRecyclerView.hideShimmerAdapter()
                    setAdapterPLate(result.data)
                }
                is Result.Error -> {
                    binding.shimmerRecyclerView.hideShimmerAdapter()
                }
            }
        })
    }

    private fun setAdapterPLate(list: RecipeList) {
        binding.rvPlate.adapter = PlateAdapter(list)
    }

    private fun setAdapterCategory(){
        binding.rvCategories.adapter = CategoryAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}