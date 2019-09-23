package com.profesional.samplemvvmrazi.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.profesional.samplemvvmrazi.ui.itemPage.ItemViewModel
import com.profesional.samplemvvmrazi.ui.listPage.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Razi on 2019/01/09.
 */
@Module(includes = [RepositoryModule::class])
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(ItemViewModel::class)
    fun bindItemViewModel(viewModel: ItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindListViewModel(viewModel: ListViewModel): ViewModel
}