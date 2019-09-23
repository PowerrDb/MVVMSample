package com.profesional.samplemvvmrazi.ui.itemPage

import com.profesional.samplemvvmrazi.remote.ItemDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class ItemRepository @Inject internal constructor(private val dataSource :ItemDataSource) :ItemInfo{

    override fun getInfo(id : String): Flowable<ItemModel> {
       return dataSource.getInfo(id)
    }

}