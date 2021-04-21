package com.example.appfood.ui.base

import androidx.fragment.app.Fragment
import com.example.appfood.databinding.LayoutToolbarBinding
import com.example.appfood.ui.main.HomeActivity

/**
 * Created by Franco on 30/3/2021
 */
open class BaseFragment(fragment: Int) : Fragment(fragment) {

    /**
     * @param view layout Binding
     * @param string title toolbar
     * @param hasBack true : have back button, yes : do not have back button
     */
    protected fun setToolbar(view: LayoutToolbarBinding, string: String, hasBack : Boolean){
        (activity as HomeActivity).setToolbar(view,string, hasBack)
    }
}