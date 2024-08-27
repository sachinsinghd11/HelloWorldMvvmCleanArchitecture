package com.example.helloworldmvvvmcleanarchitecture.di.module

import android.content.Context
import com.example.helloworldmvvvmcleanarchitecture.data.api.NetworkService
import com.example.helloworldmvvvmcleanarchitecture.data.api.NetworkServiceImpl
import com.example.helloworldmvvvmcleanarchitecture.di.ApplicationContext
import com.example.helloworldmvvvmcleanarchitecture.di.BaseUrl
import com.example.helloworldmvvvmcleanarchitecture.di.repositoryImpl.HelloWorldRepositoryImpl
import com.example.helloworldmvvvmcleanarchitecture.domain.repository.HelloWorldRepository
import com.example.helloworldmvvvmcleanarchitecture.presentation.HelloWorldApplication
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.DefaultDispatcherProvider
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.DispatcherProvider
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.NetworkHelper
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.NetworkHelperImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class HelloWorldApplicationModule(private val application: HelloWorldApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://www.youtube.com/watch?v=mfet4d2YthU/"

    @Singleton
    @Provides
    fun provideGsonFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }


    @Singleton
    @Provides
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): NetworkService {
        return NetworkServiceImpl()
        /*return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(gsonConverterFactory)
            .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build()
            .create(NetworkService::class.java)*/
    }

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()


    @Singleton
    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper = NetworkHelperImpl(context)

    @Singleton
    @Provides
    fun provideHelloWorldRepository(networkService: NetworkService): HelloWorldRepository{
        return HelloWorldRepositoryImpl(networkService)
    }

}


