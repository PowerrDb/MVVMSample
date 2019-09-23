package com.profesional.samplemvvmrazi.ui.listPage

import io.reactivex.Flowable


interface ListInfo {
    fun getListInfo(): Flowable<List<ListModel>>
}