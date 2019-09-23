package com.profesional.samplemvvmrazi.ui.itemPage

import io.reactivex.Flowable


interface ItemInfo {
    fun getInfo(id : String): Flowable<ItemModel>
}