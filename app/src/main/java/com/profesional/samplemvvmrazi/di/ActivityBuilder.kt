package jp.wasabeef.di

import com.profesional.samplemvvmrazi.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Razi on 2019/01/09.
 */
@Module
internal abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainInjector(): MainActivity
}