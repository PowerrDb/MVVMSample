package com.profesional.samplemvvmrazi.utils.ext

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by Wasabeef on 2017/10/20.
 */
@Suppress("UNCHECKED_CAST")
fun <T> FragmentActivity.findFragmentById(@IdRes id: Int): T = supportFragmentManager.findFragmentById(id) as T

inline fun FragmentActivity.setFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    val manager = supportFragmentManager
    val fragment = manager?.findFragmentById(containerViewId)
    fragment?.let { return it }
    return f().apply { manager?.beginTransaction()?.add(containerViewId, this)?.commit() }
}

inline fun FragmentActivity.replaceFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
    return f().apply { supportFragmentManager?.beginTransaction()?.replace(containerViewId, this)?.commit() }
}
