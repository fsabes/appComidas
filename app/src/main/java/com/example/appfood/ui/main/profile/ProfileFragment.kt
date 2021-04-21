package com.example.appfood.ui.main.profile

import android.os.Bundle
import android.view.View
import com.example.appfood.R
import com.example.appfood.databinding.FragmentProfileBinding
import com.example.appfood.ui.base.BaseFragment

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)
        setToolbar(binding.toolbarProfile,"Profile",true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}