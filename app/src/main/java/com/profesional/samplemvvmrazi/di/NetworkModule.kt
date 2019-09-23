package com.profesional.samplemvvmrazi.di

import com.profesional.samplemvvmrazi.App
import com.profesional.samplemvvmrazi.remote.ItemService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
/**
 * Created by Razi on 2019/01/09.
 */
@Module
open class NetworkModule {

    open fun buildOkHttpClient(app: App): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(app: App): OkHttpClient = buildOkHttpClient(app)


    @Provides
    @Reusable
    internal fun providePostApi(retrofit: Retrofit): ItemService {
        return retrofit.create(ItemService::class.java)
    }

    @Provides
    @Reusable
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}