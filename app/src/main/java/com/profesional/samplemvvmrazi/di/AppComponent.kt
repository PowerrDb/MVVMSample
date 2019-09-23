package com.profesional.samplemvvmrazi.di

import com.profesional.samplemvvmrazi.App
import com.profesional.samplemvvmrazi.ui.itemPage.ItemFragment
import com.profesional.samplemvvmrazi.ui.listPage.FragmentList
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jp.wasabeef.di.ActivityBuilder
import javax.inject.Singleton
/**
 * Created by Razi on 2019/01/09.
 */
@Singleton
@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class,ActivityBuilder::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun network(network: NetworkModule): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)

    fun inject(itemFragment: ItemFragment)
    fun inject(listFragment: FragmentList)


}


