package com.example.appfood.ui.plateDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.appfood.R
import com.example.appfood.databinding.FragmentPlateDetailBinding

class PlateDetailFragment : Fragment(R.layout.fragment_plate_detail) {

    private var _binding : FragmentPlateDetailBinding ? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlateDetailBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}