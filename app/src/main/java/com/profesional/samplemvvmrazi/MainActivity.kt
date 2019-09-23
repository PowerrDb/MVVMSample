package com.profesional.samplemvvmrazi

import com.profesional.samplemvvmrazi.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun setContentView(): Int = R.layout.activity_main
    override fun getNavControllerId(): Int = R.id.garden_nav_fragment

    override fun onCreate() {

    }

}
