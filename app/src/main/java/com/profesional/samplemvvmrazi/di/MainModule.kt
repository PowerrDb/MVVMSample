package jp.wasabeef.di

import com.profesional.samplemvvmrazi.ui.itemPage.ItemFragment
import com.profesional.samplemvvmrazi.ui.listPage.FragmentList
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Razi on 2019/01/09.
 */
@Module
internal abstract class MainModule {
    @ContributesAndroidInjector
    internal abstract fun contributeItemFragmentInjector(): ItemFragment
    @ContributesAndroidInjector
    internal abstract fun contributeListFragmentInjector(): FragmentList


}