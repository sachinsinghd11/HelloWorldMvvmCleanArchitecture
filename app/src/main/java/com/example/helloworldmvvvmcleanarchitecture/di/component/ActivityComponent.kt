package com.example.helloworldmvvvmcleanarchitecture.di.component

import com.example.helloworldmvvvmcleanarchitecture.di.ActivityScope
import com.example.helloworldmvvvmcleanarchitecture.di.module.ActivityModule
import com.example.helloworldmvvvmcleanarchitecture.presentation.ui.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [HelloWorldApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}