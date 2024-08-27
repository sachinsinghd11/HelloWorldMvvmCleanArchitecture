package com.example.helloworldmvvvmcleanarchitecture.di.module

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.helloworldmvvvmcleanarchitecture.di.ActivityContext
import com.example.helloworldmvvvmcleanarchitecture.domain.usecase.HelloWorldUseCase
import com.example.helloworldmvvvmcleanarchitecture.presentation.base.ViewModelProviderFactory
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.DispatcherProvider
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.NetworkHelper
import com.example.helloworldmvvvmcleanarchitecture.presentation.viewmodel.HelloWorldViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: ComponentActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideHelloWorldViewModel(
        useCase: HelloWorldUseCase,
        networkHelper: NetworkHelper,
        dispatcherProvider: DispatcherProvider,
        ): HelloWorldViewModel{
        return ViewModelProvider(
            activity,
            ViewModelProviderFactory(HelloWorldViewModel::class){
                HelloWorldViewModel(
                    useCase,
                    networkHelper,
                    dispatcherProvider
                )
            }
        )[HelloWorldViewModel::class.java]
    }

}