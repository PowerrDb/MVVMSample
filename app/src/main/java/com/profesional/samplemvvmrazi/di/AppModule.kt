package com.profesional.samplemvvmrazi.di

import dagger.Module

/**
 * Created by Razi on 2019/01/09.
 */
@Module(includes = [NetworkModule::class, ViewModelModule::class])
internal object AppModule {
    // If you need.
}
