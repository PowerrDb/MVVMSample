package com.profesional.samplemvvmrazi

import android.content.Context
import androidx.multidex.MultiDex
import com.profesional.samplemvvmrazi.di.DaggerAppComponent
import com.profesional.samplemvvmrazi.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


open class App : DaggerApplication() {

    lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        androidInjector = DaggerAppComponent.builder()
                .application(this)
                .network(networkModule())

                .build()
    }


    public override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    protected open fun networkModule(): NetworkModule = NetworkModule()


}