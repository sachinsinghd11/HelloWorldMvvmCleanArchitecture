package com.example.helloworldmvvvmcleanarchitecture.domain.usecase

import com.example.helloworldmvvvmcleanarchitecture.domain.model.WelcomeText
import com.example.helloworldmvvvmcleanarchitecture.domain.repository.HelloWorldRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HelloWorldUseCase @Inject constructor(private val repository: HelloWorldRepository) {

    operator fun invoke(): Flow<WelcomeText>{
        return repository.getHelloWorldMessage()
    }
}