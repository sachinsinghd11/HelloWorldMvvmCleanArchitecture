package com.example.helloworldmvvvmcleanarchitecture.presentation

import android.app.Application
import com.example.helloworldmvvvmcleanarchitecture.di.component.DaggerHelloWorldApplicationComponent
import com.example.helloworldmvvvmcleanarchitecture.di.component.HelloWorldApplicationComponent
import com.example.helloworldmvvvmcleanarchitecture.di.module.HelloWorldApplicationModule

class HelloWorldApplication : Application() {

    lateinit var applicationComponent: HelloWorldApplicationComponent


    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent =
            DaggerHelloWorldApplicationComponent.builder().helloWorldApplicationModule(
                HelloWorldApplicationModule(this)
            ).build()
        applicationComponent.inject(this)
    }
}