package com.profesional.samplemvvmrazi.ui.itemPage

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import com.profesional.samplemvvmrazi.base.BaseViewModel
import com.profesional.samplemvvmrazi.utils.Result
import com.profesional.samplemvvmrazi.utils.defaultErrorHandler
import com.profesional.samplemvvmrazi.utils.ext.applyIoScheduler
import com.profesional.samplemvvmrazi.utils.ext.toLiveData
import javax.inject.Inject

class ItemViewModel @Inject internal constructor(private val repository: ItemRepository) :
    BaseViewModel(), LifecycleObserver {

    lateinit var itemIDd: String

    val planet: LiveData<Result<ItemModel>> by lazy {
        repository.getInfo(itemIDd)
            .map { Result.success(it) }
            .doOnError(defaultErrorHandler())
            .onErrorReturn { Result.failure(it) }
            .startWith(Result.loading())
            .applyIoScheduler()
            .toLiveData()
    }
}