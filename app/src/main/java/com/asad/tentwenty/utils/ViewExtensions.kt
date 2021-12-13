package com.asad.tentwenty.utils

import android.annotation.SuppressLint
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


@SuppressLint("RestrictedApi")
fun BottomNavigationView.disableItemShiftMode() {
    this.apply {
        val menu = getChildAt(0) as BottomNavigationMenuView
        this::javaClass.get().getDeclaredField("mShiftingMode").also {
            it.isAccessible = true
            it.setBoolean(this, false)
            it.isAccessible = false

            for (i in 0 until childCount) {
                val item = getChildAt(i) as BottomNavigationItemView
                item.setShifting(false)
                // set once again checked value, so view will be updated
                item.itemData?.let { item.setChecked(it.isChecked) }
            }

        }

    }

}