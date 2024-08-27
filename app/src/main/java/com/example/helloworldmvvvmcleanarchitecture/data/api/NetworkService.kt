package com.example.helloworldmvvvmcleanarchitecture.data.api

import com.example.helloworldmvvvmcleanarchitecture.domain.model.WelcomeText

interface NetworkService {

    fun fakeNetworkCall(): WelcomeText

}