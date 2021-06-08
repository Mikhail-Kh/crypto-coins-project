package by.khryshchanovich.core.di.module

import by.khryshchanovich.core.data.network.api.CryptoCoinsApi
import by.khryshchanovich.core.data.network.retrofit.RetrofitProvider
import dagger.Module
import dagger.Provides

@Module
class ApiModule {
    @Provides
    fun provideCryptoCoinsApi(): CryptoCoinsApi {
        return RetrofitProvider().getRetrofit()
    }
}