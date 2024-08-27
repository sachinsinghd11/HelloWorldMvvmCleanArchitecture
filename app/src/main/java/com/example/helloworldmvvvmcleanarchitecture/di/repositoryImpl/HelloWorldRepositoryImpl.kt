package com.example.helloworldmvvvmcleanarchitecture.di.repositoryImpl

import com.example.helloworldmvvvmcleanarchitecture.data.api.NetworkService
import com.example.helloworldmvvvmcleanarchitecture.domain.model.WelcomeText
import com.example.helloworldmvvvmcleanarchitecture.domain.repository.HelloWorldRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HelloWorldRepositoryImpl @Inject constructor(private val networkService: NetworkService): HelloWorldRepository {
    override fun getHelloWorldMessage(): Flow<WelcomeText> {
        return flow {
            emit(networkService.fakeNetworkCall())
        }.map {
            it
        }
    }
}