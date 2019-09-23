package com.profesional.samplemvvmrazi.di

import com.profesional.samplemvvmrazi.ui.itemPage.ItemInfo
import com.profesional.samplemvvmrazi.ui.itemPage.ItemRepository
import com.profesional.samplemvvmrazi.ui.listPage.ListInfo
import com.profesional.samplemvvmrazi.ui.listPage.ListRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Razi on 2019/01/09.
 */
@Module
interface RepositoryModule {
    @Binds
    fun bindItemRepository(repository: ItemRepository): ItemInfo

    @Binds
    fun bindListRepository(repository: ListRepository): ListInfo


}