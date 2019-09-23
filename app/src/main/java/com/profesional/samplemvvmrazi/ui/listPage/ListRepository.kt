package com.profesional.samplemvvmrazi.ui.listPage

import com.profesional.samplemvvmrazi.remote.ItemDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class ListRepository @Inject internal constructor(private val dataSource :ItemDataSource) :
    ListInfo {

    override fun getListInfo(): Flowable<List<ListModel>> {
       return dataSource.getListInfo()
    }

}