package com.tsu.makeupapps.settings

import androidx.fragment.app.Fragment
import com.tsu.makeupapps.R

class SettingsFragment:Fragment(R.layout.fragment_settngs) {
    companion object {
        val TAG = SettingsFragment::class.java.simpleName
        fun newInstance() = SettingsFragment()
    }
}