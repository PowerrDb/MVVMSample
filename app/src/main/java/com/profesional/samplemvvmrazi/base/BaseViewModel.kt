package com.profesional.samplemvvmrazi.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Razi on 2019/10/09.
 */

open class BaseViewModel : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}