package com.profesional.samplemvvmrazi.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
/**
 * Created by Razi on 2019/10/09.
 */
abstract class BaseActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(getNavControllerId())
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentView())
        onCreate()
    }

    abstract fun getNavControllerId(): Int
    abstract fun setContentView(): Int
    abstract fun onCreate()
}