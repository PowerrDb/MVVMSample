package com.profesional.samplemvvmrazi.utils.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import org.reactivestreams.Publisher

/**
 * Created by Wasabeef on 2018/03/05.
 */
fun <T> Publisher<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this) as LiveData<T>

fun <T : Any?> Observable<T>.toLiveData(strategy: BackpressureStrategy = BackpressureStrategy.LATEST) = toFlowable(strategy).toLiveData()