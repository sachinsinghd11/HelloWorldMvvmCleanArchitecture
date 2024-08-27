package com.example.helloworldmvvvmcleanarchitecture.domain.repository

import com.example.helloworldmvvvmcleanarchitecture.domain.model.WelcomeText
import kotlinx.coroutines.flow.Flow

interface HelloWorldRepository {
    fun getHelloWorldMessage(): Flow<WelcomeText>
}