package com.example.appfood.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.example.appfood.databinding.LayoutToolbarBinding

/**
 * Created by Franco on 30/3/2021
 */
open class BaseActivity : AppCompatActivity() {

    /**
     * @param view layout Binding
     * @param title title toolbar
     * @param hasBack true : have back button, yes : do not have back button
     */
    fun setToolbar(view: LayoutToolbarBinding, title: String, hasBack : Boolean = false) {
        setSupportActionBar(view.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(hasBack)
            setDisplayShowTitleEnabled(false)
        }
        view.tvToolbar.text = title
        view.toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}