package com.benedekvarga.weather.view.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager



fun Activity.addFragmentToActivity(
    fragmentManager: FragmentManager,
    fragment: Fragment, frameId: Int) {
        checkNotNull(fragmentManager)
        checkNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
}