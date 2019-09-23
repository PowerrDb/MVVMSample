package com.profesional.samplemvvmrazi.di

import android.content.Context
import com.profesional.samplemvvmrazi.App

/**
 * Created by Razi on 2019/01/09.
 */
object AppInjection {
    fun of(context: Context?): AppComponent {
        return (context!!.applicationContext as App).applicationInjector() as AppComponent
    }
}