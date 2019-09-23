package com.profesional.samplemvvmrazi.ui.listPage

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import com.profesional.samplemvvmrazi.base.BaseViewModel
import com.profesional.samplemvvmrazi.utils.defaultErrorHandler
import javax.inject.Inject
import com.profesional.samplemvvmrazi.utils.Result
import com.profesional.samplemvvmrazi.utils.ext.applyIoScheduler
import com.profesional.samplemvvmrazi.utils.ext.toLiveData

class ListViewModel @Inject internal constructor(private val repository: ListRepository) : BaseViewModel(),LifecycleObserver {

    val listInfo: LiveData<Result<List<ListModel>>> by lazy {
        repository.getListInfo()
            .map { Result.success(it) }
            .doOnError(defaultErrorHandler())
            .onErrorReturn { Result.failure(it) }
            .startWith(Result.loading())
            .applyIoScheduler()
            .toLiveData()
    }

}