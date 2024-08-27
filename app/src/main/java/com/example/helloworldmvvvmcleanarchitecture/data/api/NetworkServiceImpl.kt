package com.example.helloworldmvvvmcleanarchitecture.data.api

import com.example.helloworldmvvvmcleanarchitecture.domain.model.WelcomeText

class NetworkServiceImpl(): NetworkService {
    override fun fakeNetworkCall(): WelcomeText {
        return WelcomeText("Fake network call")
    }
}