package com.tsu.makeupapps.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.FragmentSettngsBinding

class SettingsFragment:Fragment(R.layout.fragment_settngs) {
    companion object {
        val TAG = SettingsFragment::class.java.simpleName
        fun newInstance() = SettingsFragment()
    }
    private lateinit var viewbinding: FragmentSettngsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewbinding = FragmentSettngsBinding.bind(view)
    }

}