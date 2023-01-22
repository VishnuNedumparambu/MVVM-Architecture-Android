package com.example.mvvm

import android.app.Application
import com.example.mvvm.di.component.ApplicationComponent
import com.example.mvvm.di.module.ApplicationModule
import com.example.mvvm.di.component.DaggerApplicationComponent

class MVVMApplication :Application(){

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies(){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}