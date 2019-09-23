package com.profesional.samplemvvmrazi.remote

import javax.inject.Inject

class ItemDataSource @Inject internal constructor(private val service: ItemService){

    fun getInfo(id : String)=service.getInfo(id)

    fun getListInfo()=service.getListInfo()

}
