package com.example.helloworldmvvvmcleanarchitecture.di.component

import android.content.Context
import com.example.helloworldmvvvmcleanarchitecture.data.api.NetworkService
import com.example.helloworldmvvvmcleanarchitecture.di.ApplicationContext
import com.example.helloworldmvvvmcleanarchitecture.di.module.HelloWorldApplicationModule
import com.example.helloworldmvvvmcleanarchitecture.domain.usecase.HelloWorldUseCase
import com.example.helloworldmvvvmcleanarchitecture.presentation.HelloWorldApplication
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.DispatcherProvider
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.NetworkHelper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HelloWorldApplicationModule::class])
interface HelloWorldApplicationComponent {

    fun inject(application: HelloWorldApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDispatcherProvider(): DispatcherProvider

    fun getNetworkHelper(): NetworkHelper

    fun getHelloWorldUseCase(): HelloWorldUseCase

}