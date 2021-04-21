package com.example.appfood.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.appfood.R
import com.example.appfood.databinding.ActivityHomeBinding
import com.example.appfood.ui.base.BaseActivity
import com.example.appfood.ui.main.home.HomeFragment
import com.example.appfood.ui.main.maps.MapsFragment
import com.example.appfood.ui.main.profile.ProfileFragment
import com.example.appfood.ui.main.search.SearchFragment

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val homeFragment = HomeFragment()
         val searchFragment = SearchFragment()
         val profileFragment = ProfileFragment()
         val mapsFragment = MapsFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.search -> makeCurrentFragment(searchFragment)
                R.id.maps -> makeCurrentFragment(mapsFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            if (!fragment.isAdded) {
                add(R.id.containerFragment, fragment)
            }
            for (fm in supportFragmentManager.fragments) {
                hide(fm)
            }
            show(fragment)
            commit()
        }
}