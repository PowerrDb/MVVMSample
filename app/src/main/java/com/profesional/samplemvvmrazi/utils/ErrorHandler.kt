package com.profesional.samplemvvmrazi.utils

import android.util.Log


/**
 * Created by Wasabeef on 2018/03/05.
 */
fun defaultErrorHandler(): (Throwable) -> Unit = { e -> Log.e("erorr", e.toString()) }