package com.profesional.samplemvvmrazi.remote

import com.profesional.samplemvvmrazi.ui.itemPage.ItemModel
import com.profesional.samplemvvmrazi.ui.listPage.ListModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


interface ItemService {
    @GET("photos/{id}")
    fun getInfo(@Path("id") id : String): Flowable<ItemModel>

    @GET("photos")
    fun getListInfo(): Flowable<List<ListModel>>
}